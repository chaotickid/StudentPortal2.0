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

import {
    AlertDialog,
    AlertDialogAction,
    AlertDialogCancel,
    AlertDialogContent,
    AlertDialogDescription,
    AlertDialogFooter,
    AlertDialogHeader,
    AlertDialogTitle,
    AlertDialogTrigger,
} from "@/components/ui/alert-dialog"
import {Button} from "@/components/ui/button";


const NavBar = ({ButtonName, DialogueTitle, DialogDescription, icon}) => {

    return (
        <div>
            <AlertDialog>
                <AlertDialogTrigger asChild>
                    {icon? icon: <Button variant="outline">{ButtonName}</Button>}
                </AlertDialogTrigger>
                <AlertDialogContent>
                    <AlertDialogHeader>
                        <AlertDialogTitle>{DialogueTitle}</AlertDialogTitle>
                        <AlertDialogDescription>
                            {DialogDescription}
                        </AlertDialogDescription>
                    </AlertDialogHeader>
                    <AlertDialogFooter>
                        <AlertDialogCancel>Cancel</AlertDialogCancel>
                        <AlertDialogAction>Continue</AlertDialogAction>
                    </AlertDialogFooter>
                </AlertDialogContent>
            </AlertDialog>
        </div>
    )
}

export default NavBar