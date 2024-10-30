import Authentication from '@/pages/Authentication'
import HomePage from '@/pages/HomePage'
import ProductList from '@/pages/ProductList'
import { Register } from '@/pages/Register'
import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function AppRouter() {
  return (
    
      <BrowserRouter>
      <div className='min-h-screen w-full'>
        
      <Routes>
            <Route path='/Home' element={<HomePage/>}/>
            <Route path='/List' element={<ProductList/>}/>
            <Route path='/Auth' element={<Authentication/>}/>
            <Route path='/register' element={<Register/>}/>
        </Routes>
      </div>
      
      </BrowserRouter>
   
  )
}

export default AppRouter
