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
import DialogueBox from "@/app/_components/DialogueBox";


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
        dialogueTitle: "",
        dialogDescription: "",
        icon: <UserRoundPen/>
    },
    {
        id: 2,
        name: "Setting",
        url: "/setting",
        dialogueTitle: "",
        dialogDescription: "",
        icon: <SlidersHorizontal/>
    },
    {
        id: 3,
        name: "Logout",
        url: "/logout",
        dialogueTitle: "",
        dialogDescription: "",
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
                            {/*<Link href={item.url}>*/}
                                {/*<div*/}
                                {/*    className="flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200">*/}
                                {/*    <h1>{item.icon}</h1>*/}
                                {/*    <h1>{item.name}</h1>*/}

                                {/*</div>*/}
                                <div
                                    className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200 mt-5 text-gray-400"}>
                                    <h1>{item.icon}</h1>
                                    <DialogueBox icon={<h1>{item.name}</h1>} DialogueTitle={item.dialogueTitle}
                                                 DialogDescription={item.dialogDescription}></DialogueBox>
                                </div>
                            {/*</Link>*/}
                        </div>
                    )
                })}

                {/*<div*/}
                {/*    className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200 mt-5 text-gray-400"}>*/}
                {/*    <h1><LogOut/></h1>*/}
                {/*    <DialogueBox icon={<h1>Logout</h1>} DialogueTitle={"Want to logout ?"}*/}
                {/*                 DialogDescription={"Once logged out need to sign in again, save changes before log out"}></DialogueBox>*/}
                {/*</div>*/}


            </div>

            <div className={"ml-[15%] p-5"}>

                <div className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200"}>
                    <Input type="text" placeholder="Search" />

                    <DialogueBox
                        icon={<MessageCircle></MessageCircle>}
                        DialogueTitle={"Notification"}
                        DialogDescription={"See notifications here"}
                        className={"mb-10"}></DialogueBox>

                    <SpeakerIcon></SpeakerIcon>
                    <h1 className={"text-xl text-gray-400"}>Aditya Patil <span>admin</span></h1>
                </div>
            </div>
        </div>
    )
}

export default NavBar