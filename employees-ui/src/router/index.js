import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/Employees',
      name: 'Employees',
      component: () =>
        import ('@/components/Employees')
    },
    {
      path: '/Form',
      name: 'Form',
      component: () =>
        import ('@/components/Form')
    },
    {
      path: '/404',
      name: '404',
      component: () =>
        import ('@/views/error/404')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
