'use client'
import { Button } from '@/components/ui/button'
import Image from 'next/image'
import Link from 'next/link'
import { usePathname } from 'next/navigation'
import React from 'react'


const navList = [

    {
        id: 1,
        name: "Users",
        url: "/users"
    },
    {
        id: 2,
        name: "Courses",
        url: "/courses"
    },
    {
        id: 3,
        name: "Meetings",
        url: "/meeting"
    },
    {
        id: 4,
        name: "Profile",
        url: "/profile"
    },
    {
        id: 5,
        name: "Payments",
        url: "/payments"
    }
]

const NavBar = () => {

    const path = usePathname();

    console.log(path)

    return (
        <div className='border container mx-auto shadow-lg'><header classNameName="text-gray-600 body-font">
            <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
                <div className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">

                    <Link href={"/users"}><Image src={"./logo.svg"} height={24} width={24}></Image></Link>
                    {/* <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
                        <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
                    </svg> */}
                    <Link href={"/users"}><span className="ml-3 text-xl cursor-pointer">StudentPortal</span></Link>

                </div>
                <nav className="md:ml-auto flex flex-wrap items-center text-base justify-center">

                    {navList.map((item, index) => {
                        return (
                            <div key={index}>
                                {path === item.url ? <Link href={item.url} ><h1 className="mr-5 hover:text-gray-900 font-bold cursor-pointer ease-in duration-100">{item.name}</h1></Link> : <Link href={item.url}><h1 className="mr-5 hover:text-gray-900 hover:font-bold cursor-pointer ease-in duration-100">{item.name}</h1></Link>}
                            </div>
                        )
                    })}
                </nav>
                {/* <button className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">Button
                    <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-1" viewBox="0 0 24 24">
                        <path d="M5 12h14M12 5l7 7-7 7"></path>
                    </svg>
                </button> */}
            </div>
        </header></div>
    )
}

export default NavBar