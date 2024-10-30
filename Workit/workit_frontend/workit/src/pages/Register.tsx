"use client"

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { Card, CardContent, CardFooter, CardHeader } from '@/components/ui/card'
import { Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from '@/components/ui/form'
import { Input } from '@/components/ui/input';
import { FormInput } from 'lucide-react';
import React from 'react'

import { LoginForm } from './LoginForm';

import {RegisterForm} from '@/pages/RegisterForm'
import { toast } from "@/hooks/use-toast.ts"
import { Button } from "@/components/ui/button"


const FormSchema = z.object({
  username: z.string().min(2, {
    message: "Username must be at least 2 characters.",
  }),
})

export function Register() {
  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      username: "",
    },
  })

  function onSubmit(data: z.infer<typeof FormSchema>) {
    toast({
      title: "You submitted the following values:",
      description: (
        <pre className="mt-2 w-[340px] rounded-md bg-slate-950 p-4">
          <code className="text-white">{JSON.stringify(data, null, 2)}</code>
        </pre>
      ),
    })
  }

  return (
    <div className="backdrop-brightness-40
    bg-gradient-to-r from-chart-1 to-chart-2 flex flex-grow-0 w-screen min-h-screen grid grid-cols-12 p-4">
     
     {/* Left Section (taking up 8 columns) */}
     <div className="col-span-12 lg:col-span-4 flex flex-col items-center justify-center text">
       <h1 className="hover:transition-colors shadow-orange-100 text-9xl justify-start text-left text-white font-bold mb-4">Workit</h1>
       <h2 className="bg-black text-justify shadow-orange-100 text-2xl text-white font-mono mb-4">Find the right job 
         for you.</h2>
     </div>

     {/* Right-Aligned Card Section (taking up 4 columns) */}
     <div className="col-span-12 lg:col-span-8 flex items-center justify-center">
       <Card className="border-0 shadow-md w-full max-w-md shadow-2xl ">
         <CardHeader className='text-2xl font-bold'>
           <h1>Register.</h1>
         </CardHeader>
         <hr className=''></hr>
         <CardContent className="p-6">
           <RegisterForm/>
         </CardContent>
         <CardFooter>

         </CardFooter>
       </Card>
     </div>
     
   </div>
  )
}
