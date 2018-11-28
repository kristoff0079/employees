import axios from "axios";
import utils from '@/utils/utils.js'

import {
  Message,
  MessageBox
} from "element-ui"

const service = axios.create({
  baseURL: 'http://kristoff.com:8001',
  timeout: 5000
});

service.interceptors.request.use(config => {
    let locale = utils.getUrlParam('locale');
    if(locale == null) {
        locale = 'zh_CN'
    }
    config.headers['X-Token'] = new Date().getTime();
    config.headers['Accept-Language'] = locale;
    config.headers['Authorization'] = new Date().getTime();
    config.params['t'] = new Date().getTime();
    return config;
});


//service.defaults.headers.common['X-Token'] = new Date().getTime();

service.interceptors.response.use(response => {
  let data = response.data;
  if (data.status != 1) {
    MessageBox.alert('系统内部错误，请联系管理员维护', '错误', {
        confirmButtonText: '确定',
        type: 'error'
    })
    //Promise.reject('error')
  }
  return response;
}, error => {
  console.log(error.response)
  let status = error.response.status;
  if (status == 404) {
    MessageBox.alert(error.response.request.responseText, 'Error', {
      type: 'error',
      confirmButtonText: 'Ok'
    })
  } else {
    Message({
      message: '登录连接超时（后台不能连接，请联系系统管理员）',
      type: 'error',
      duration: 5 * 1000
    })
  }
  return Promise.reject(error)
});


export default service;
