<template>
  <div class="app-container">
    <el-table :data="list" v-loading="listLoading" element-loading-text="Query..." size="small">
      <el-table-column label="Emp No." prop="empNo" align="center" sortable />
      <el-table-column label="Birth Date" prop="birthDate" align="center" sortable />
      <el-table-column label="First Name" prop="firstName" align="center" sortable />
      <el-table-column label="Last Name" prop="lastName" align="center" sortable />
      <el-table-column label="Gender" prop="gender" align="center" :filters="[{text:'M', value:'M'}, {text:'F', value:'F'}]" filter-placement="bottom-end"
        :filter-method="filterGender">
        <template slot-scope="scope">
          <el-tag type="scope.row.gender === 'M' ? 'primary' : 'scuess'">
            {{scope.row.gender}}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="Hire Date" prop="hireDate" align="center" sortable />
    </el-table>

    <div class="block">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="listQuery.currentPage"
        :page-sizes="[20, 50, 100, 200]" :page-size="listQuery.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="this.total">
      </el-pagination>
    </div>

  </div>
</template>

<style>
  .msgBox {}

  .msgBox p {
    max-height: 500px;
    overflow-y: auto
  }

</style>


<script>
  import request from "@/utils/request.js";
  import {
    Message,
    MessageBox
  } from "element-ui"

  export default {
    name: "Employees",
    data() {
      return {
        data: null,
        total: null,
        list: null,
        listLoading: true,
        listQuery: {
          currentPage: 1,
          pageSize: 20
        }
      };
    },

    created() {
      this.getList();
    },
    methods: {
      getList() {
        console.log(this.listQuery);
        this.listLoading = true;
        let queryParam = this.listQuery;
        request({
            url: "/emp/emp/findEmployeeList",
            method: "get",
            params: queryParam
          })
          .then(response => {
            this.data = response.data.data;
            this.list = this.data.list;
            this.total = this.data.total;
            this.listLoading = false;
          })
          .catch(err => {
            this.data = null;
            this.listLoading = false;
          });
      },

      filterGender(value, row) {
        return row.gender === value;
      },

      handleSizeChange(size) {
        this.listQuery.pageSize = size;
        this.getList();
      },

      handleCurrentChange(page) {
        this.listQuery.currentPage = page;
        this.getList();
      }
    }
  };

</script>
