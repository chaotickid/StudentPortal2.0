'use client'
import Image from 'next/image'
import Link from 'next/link'
import {usePathname} from 'next/navigation'
import React from 'react'
import {
    BookOpenCheck,
    HandCoins,
    HomeIcon,
    LogOut, MessageCircle,
    Presentation,
    SlidersHorizontal, SpeakerIcon,
    UserIcon,
    UserRoundCog,
    UserRoundPen
} from "lucide-react";
import {Input} from "@/components/ui/input";


const mainNavList = [

    {
        id: 1,
        name: "Home",
        url: "/",
        icon: <HomeIcon/>,
    },
    {
        id: 2,
        name: "Teacher",
        url: "/teachers",
        icon: <UserIcon></UserIcon>
    },
    {
        id: 3,
        name: "Student",
        url: "/student",
        icon: <UserRoundCog/>
    },
    {
        id: 4,
        name: "Parents",
        url: "/parents",
        icon: <HomeIcon/>,
    },
    {
        id: 5,
        name: "Classes",
        url: "/classes",
        icon: <Presentation/>
    },
    {
        id: 6,
        name: "Lessons",
        url: "/lessons",
        icon: <BookOpenCheck/>
    },
    {
        id: 7,
        name: "Payments",
        url: "/payments",
        icon: <HandCoins/>
    }
]

const otherNavList = [

    {
        id: 1,
        name: "Profile",
        url: "/profile",
        icon: <UserRoundPen/>
    },
    {
        id: 2,
        name: "Setting",
        url: "/setting",
        icon: <SlidersHorizontal/>
    },
    {
        id: 3,
        name: "Logout",
        url: "/Logout",
        icon: <LogOut/>
    }
]

const NavBar = () => {

    const path = usePathname();

    console.log(path)

    return (

        <div>
            <div className={"w-[15%] h-screen fixed  p-5 border-r-2 overflow-hidden"}>

                <div className={"flex items-center gap-5 cursor-pointer"}>
                    <Image src={"/logo.svg"} alt={""} height={30} width={30}></Image>
                    <h1 className={"text-gray-400 text-3xl"}>StudentPortal</h1>
                </div>

                <h1 className={"text-gray-400 mt-5"}>MENU</h1>


                {mainNavList.map((item, index) => {
                    return (
                        <div key={index} className={"mt-5 text-gray-400"}>
                            <Link href={item.url}>
                                <div
                                    className="flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200">
                                    <h1>{item.icon}</h1>
                                    <h1>{item.name}</h1>
                                </div>
                            </Link>
                        </div>
                    )
                })}

                <h1 className={"text-gray-400 mt-5"}>OTHER</h1>

                {otherNavList.map((item, index) => {
                    return (
                        <div key={index} className={"mt-5 text-gray-400"}>
                            <Link href={item.url}>
                                <div
                                    className="flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200">
                                    <h1>{item.icon}</h1>
                                    <h1>{item.name}</h1>

                                </div>
                            </Link>
                        </div>
                    )
                })}


            </div>

            <div className={"ml-[15%] p-5"}>

                <div className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200"}>
                    <Input type="text" placeholder="Search" />

                    <MessageCircle></MessageCircle>
                    <SpeakerIcon></SpeakerIcon>
                    <h1 className={"text-xl text-gray-400"}>Aditya Patil <span>admin</span></h1>
                </div>
            </div>
        </div>



        // <div className='border container mx-auto shadow-lg'><header className="text-gray-600 body-font">
        //     <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        //         <div className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
        //
        //             <Link href={"/users"}><Image src={"./logo.svg"} height={24} width={24}></Image></Link>
        //             {/* <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
        //                 <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
        //             </svg> */}
        //             <Link href={"/users"}><span className="ml-3 text-xl cursor-pointer">StudentPortal</span></Link>
        //
        //         </div>
        //         <nav className="md:ml-auto flex flex-wrap items-center text-base justify-center">
        //
        //             {navList.map((item, index) => {
        //                 return (
        //                     <div key={index}>
        //                         {path === item.url ? <Link href={item.url} ><h1 className="mr-5 hover:text-gray-900 font-bold cursor-pointer ease-in duration-100">{item.name}</h1></Link> : <Link href={item.url}><h1 className="mr-5 hover:text-gray-900 hover:font-bold cursor-pointer ease-in duration-100">{item.name}</h1></Link>}
        //                     </div>
        //                 )
        //             })}
        //         </nav>
        //         {/* <button className="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">Button
        //             <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" className="w-4 h-4 ml-1" viewBox="0 0 24 24">
        //                 <path d="M5 12h14M12 5l7 7-7 7"></path>
        //             </svg>
        //         </button> */}
        //     </div>
        // </header></div>
    )
}

export default NavBar