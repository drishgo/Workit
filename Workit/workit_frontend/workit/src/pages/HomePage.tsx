

import React, { useState } from 'react'
// import { useRouter } from 'next/navigation'
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter } from "@/components/ui/card"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { useNavigate } from 'react-router-dom'
// import ButtonLink from './ui/buttonLink'


export default function HomePage() {
  const [searchQuery, setSearchQuery] = useState('')
  const navigation = useNavigate()

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault()
    if (searchQuery.trim()) {
      try {
        const response = await fetch(`https://localhost:8181/searchPosts/${searchQuery}`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          },
        })

        if (response.ok) {
          // Redirect to the search results page
          //router.push(`/search-results?query=${searchQuery}`)
        } else {
          console.error('Search request failed')
          // You might want to show an error message to the user here
        }
      } catch (error) {
        console.error('Error during search:', error)
        // You might want to show an error message to the user here
      }
    }
  }
  function signUpHandle(){

  }
  return (
    <div className="w-screen min-h-screen flex flex-col">
       <nav className="bg-black p-4 relative z-10">
      <div className="container mx-auto flex items-center justify-between">
        <h1 className="text-white text-2xl font-sans font-extrabold">
          <a href="/homepage" className="shadow-white hover:shadow-lg transition-shadow duration-200">
            WORKIT
          </a>
        </h1>
        <div className="flex items-center space-x-4">
          <Button asChild variant="ghost" className="text-white hover:text-primary-foreground">
            <a href="/profile">Profile</a>
          </Button>
          <Avatar>
            <AvatarImage src="https://github.com/shadcn.png" alt="User avatar" />
            <AvatarFallback>CN</AvatarFallback>
          </Avatar>
        </div>
      </div>
    </nav>

      {/* Main content */}
     
      <main className="flex-grow flex items-center justify-center bg-stone-900 relative overflow-hidden">
        {/* Backdrop artwork */}
        <div 
          className="absolute inset-0 bg-cover bg-center"
          style={{
            backgroundImage: "url('@/assets/WorkitHome.jpeg?height=1080&width=1920')",
            filter: "brightness(50%)"
          }}
        ></div>

        {/* Card with search elements */}
        <Card className=" hover:shadow-white shadow-xl  transition-shadow duration-800  relative z-10 w-full max-w-md mx-4 ">
          <CardContent className="p-6">
            <h2 className="text-4xl font-extrabold mb-6 text-center">
              Workit
              <br />
              <span className="text-3xl font-mono">For you. By you.</span>
            </h2>
            <form onSubmit={handleSearch} className="space-y-4 p-3 shadow-transparent shadow-inner  rounded-md">
              <Input
                className="shadow-md shadow-slate-300"
                type="text"
                placeholder="Search Work"
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
              />
              <Button type="submit" className="w-full bg-black text-white hover:bg-gray-800">
                search
              </Button>
            </form>
            
          </CardContent>
          <CardFooter>
            <div className='text-center items-center flex justify-center'>
            <p >not a member yet?</p>
            <br/>
           <form action='/Register'>
           <Button variant="link" className=" text-center justify-center" >Sign up</Button>  
           </form>
            </div>
          </CardFooter> 
        </Card>
        
      </main> 
     
         
    </div>
  )
}