'use client'
import { Input } from '@/components/ui/input'
import React from 'react'

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuRadioGroup,
  DropdownMenuRadioItem,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"
import { Button } from '@/components/ui/button'
import { useRouter } from 'next/navigation'

const page = () => {

  const router = useRouter();
  
  const [selected, setSelected] = React.useState("ID")



  const onclickHandler = ()=>{
    router.push("/users/adduser")
  }

  return (
    <div className='container mx-auto mt-5'>
      <div className='flex justify-between'>
        <div className='flex items-center gap-5 w-[75%]'>
          <Input type="text" placeholder="Search user"></Input>
          <span>by</span>
          <div><DropdownMenu>
            <DropdownMenuTrigger asChild>
              <Button variant="outline">{selected}</Button>
            </DropdownMenuTrigger>
            <DropdownMenuContent className="w-56">
              <DropdownMenuLabel>Search Parameters</DropdownMenuLabel>
              <DropdownMenuSeparator />
              <DropdownMenuRadioGroup value={selected} onValueChange={setSelected}>
                <DropdownMenuRadioItem value="ID">ID</DropdownMenuRadioItem>
                <DropdownMenuRadioItem value="EMAIL">EMAIL</DropdownMenuRadioItem>
                <DropdownMenuRadioItem value="right">RIGHT</DropdownMenuRadioItem>
              </DropdownMenuRadioGroup>
            </DropdownMenuContent>
          </DropdownMenu></div>
        </div>
        <div onClick={onclickHandler}>

          <Button>Add User</Button>
        </div>
      </div>




    </div>
  )
}

export default page