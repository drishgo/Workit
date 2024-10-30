import { Button } from '@/components/ui/button';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import React, { useState } from 'react'

const ProductList = () => {
    const [count,setCount]=useState(0);
    const userData = [
        {
          id: 1,
          name: "John Doe",
          email: "john.doe@example.com"
        },
        {
          id: 2,
          name: "Jane Smith",
          email: "jane.smith@example.com"
        },
        {
          id: 3,
          name: "Michael Johnson",
          email: "michael.johnson@example.com"
        },
        {
          id: 4,
          name: "Emily Davis",
          email: "emily.davis@example.com"
        }
      ];
     
      
    return (
    <main className='text-yellow-300 w-screen min-h-screen bg-gradient-to-br from-slate-900 to-green-200 flex items-center justify-center'>
      <Card className=" font-mono transition-shadow hover:shadow-red-600  shadow-red-300 shadow-lg w-[350px]">
        <CardHeader>
            <CardTitle className='font-bold underline'>Profile</CardTitle>
            <CardDescription className='font-extralight from-neutral-500'>details:</CardDescription>
        </CardHeader>
        <CardContent>
        <div className='justify-self-center font-semibold font-mono'>
                <ul>
                    <li>{userData[count].id}</li>
                    <li>{userData[count].email}</li>
                    <li>{userData[count].name}</li>
                </ul>
        </div>
        </CardContent>
        <hr></hr>
        <CardFooter className='flex justify-between'>
            <Button onClick={()=>count===0?setCount(userData.length):setCount(count-1)} variant="outline"className='shadow-sm shadow-slate-700'>Back</Button>


            <Button onClick={()=>count>userData.length-1?setCount(0):setCount(count+1)}variant="outline" className='shadow-sm shadow-slate-700'>Next</Button>
        </CardFooter>
      </Card>
      <h1 className='font-mono flex items-center'>{count}</h1>
    </main>
  )
}

export default ProductList
