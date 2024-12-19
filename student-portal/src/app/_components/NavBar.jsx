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
    Presentation, Settings2Icon,
    SlidersHorizontal, SpeakerIcon,
    UserIcon,
    UserRoundCog,
    UserRoundPen
} from "lucide-react";
import {Input} from "@/components/ui/input";
import DialogueBox from "@/app/_components/DialogueBox";
import { IoHomeOutline } from "react-icons/io5";
import { FaChalkboardTeacher } from "react-icons/fa";
import { PiStudentFill } from "react-icons/pi";
import { RiParentLine } from "react-icons/ri";
import { GrDocumentNotes } from "react-icons/gr";
import { FaAmazonPay } from "react-icons/fa";
import { SiGoogleclassroom } from "react-icons/si";
import { ImProfile } from "react-icons/im";
import { RiListSettingsFill } from "react-icons/ri";
import { LuLogOut } from "react-icons/lu";
import { SiGooglemessages } from "react-icons/si";
import { IoIosNotifications } from "react-icons/io";
import {ThemeToggle} from "@/app/_components/theme-toggle";
import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";



const mainNavList = [

    {
        id: 1,
        name: "Home",
        url: "/",
        icon: <IoHomeOutline />
    },
    {
        id: 2,
        name: "Teacher",
        url: "/teachers",
        icon: <FaChalkboardTeacher />
    },
    {
        id: 3,
        name: "Student",
        url: "/students",
        icon: <PiStudentFill />
    },
    {
        id: 4,
        name: "Parents",
        url: "/parents",
        icon: <RiParentLine />
    },
    {
        id: 5,
        name: "Classes",
        url: "/classes",
        icon: <SiGoogleclassroom />
    },
    {
        id: 6,
        name: "Notes",
        url: "/notes",
        icon: <GrDocumentNotes />
    },
    {
        id: 7,
        name: "Payments",
        url: "/payments",
        icon:<FaAmazonPay />
    }
]

const otherNavList = [

    {
        id: 1,
        name: "Profile",
        url: "/profile",
        dialogueTitle: "",
        dialogDescription: "",
        icon: <ImProfile />
    },
    {
        id: 2,
        name: "Setting",
        url: "/setting",
        dialogueTitle: "",
        dialogDescription: "",
        icon: <RiListSettingsFill />
    },
    {
        id: 3,
        name: "Logout",
        url: "/logout",
        dialogueTitle: "",
        dialogDescription: "",
        icon: <LuLogOut />
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

                <h1 className={"text-gray-500 mt-5"}>MENU</h1>


                {mainNavList.map((item, index) => {
                    return (
                        <div key={index} className={"mt-5 text-gray-500"}>
                            <Link href={item.url}>
                                <div
                                    className="flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200">
                                    <h1 className={"text-3xl"}>{item.icon}</h1>
                                    <h1>{item.name}</h1>
                                </div>
                            </Link>
                        </div>
                    )
                })}

                <h1 className={"text-gray-500 mt-5"}>OTHER</h1>

                {otherNavList.map((item, index) => {
                    return (
                        <div key={index} className={"mt-5 text-gray-500"}>
                            <Link href={item.url}>
                            <div
                                className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200 mt-5 text-gray-500"}>
                                <h1 className={"text-3xl"}>{item.icon}</h1>
                                <h1>{item.name}</h1>
                            </div>
                            </Link>

                        </div>
                    )
                })}
            </div>

            <div className={"ml-[15%] p-5"}>
                <div
                    className={"flex items-center gap-5 cursor-pointer hover:text-gray-900 transition ease-in-out duration-200"}>
                    <Input type="text" placeholder="Search"/>
                    <DialogueBox
                        icon={<h1 className={"text-3xl"}><SiGooglemessages></SiGooglemessages></h1>}
                        DialogueTitle={"Messages"}
                        DialogDescription={"See messages here"}
                        className={"mb-10"}></DialogueBox>
                    <DialogueBox
                        icon={<h1 className={"text-3xl"}><IoIosNotifications></IoIosNotifications></h1>}
                        DialogueTitle={"Notification"}
                        DialogDescription={"See notifications here"}
                        className={"mb-10"}></DialogueBox>
                    <ThemeToggle />
                    <Avatar className="h-12 w-12">
                        <AvatarImage src="/placeholder-avatar.jpg" alt="Student"/>
                        <AvatarFallback>AP</AvatarFallback>
                    </Avatar>
                </div>
            </div>
        </div>
    )
}

export default NavBar