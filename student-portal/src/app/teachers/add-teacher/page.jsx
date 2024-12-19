'use client'
import React from 'react';
import {Button} from "@/components/ui/button";
import Link from "next/link";
import { IoIosRefreshCircle } from "react-icons/io";
import {ToastAction} from "@/components/ui/toast";
import {useToast} from "@/hooks/use-toast";

const Page = () => {

    const [password, setPassword] = React.useState("");

    const generatePassword = ()=>{
        setPassword("")
        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()_-+=?';
        let password1 = '';

        for (let i = 0; i < 9; i++) {
            const randomIndex = Math.floor(Math.random() * characters.length);
            password1 += characters[randomIndex];
        }
        console.log("password: ", password1);
        setPassword(password1);
        return password1;
    }
    const { toast } = useToast()

    return (
        <div className={"ml-[15%] px-5"}>
            <Link href={"/teachers"}><Button variant="outline">Back</Button></Link>
            <section className="text-gray-600 body-font relative">
                <div className="container px-5 py-7 mx-auto">
                    <div className="flex flex-col text-center w-full mb-12">
                        <h1 className="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900">Add Teacher</h1>
                        <p className="lg:w-2/3 mx-auto leading-relaxed text-base">Quick add teacher form</p>
                    </div>
                    <div className="lg:w-1/2 md:w-2/3 mx-auto">
                        <div className="flex flex-wrap -m-2">
                            <div className="p-2 w-1/2">
                                <div className="relative">
                                    <label htmlFor="name" className="leading-7 text-sm text-gray-600">Name</label>
                                    <input type="text" id="name" name="name"
                                           className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                                </div>
                            </div>
                            <div className="p-2 w-1/2">
                                <div className="relative">
                                    <label htmlFor="email" className="leading-7 text-sm text-gray-600">Email</label>
                                    <input type="email" id="email" name="email"
                                           className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                                </div>
                            </div>
                            <div className="p-2 w-1/2">
                                    <label htmlFor="name" className="leading-7 text-sm text-gray-600">Password</label>
                                <div className="flex items-center">
                                    <input value={password} type="text" id="name" name="name" disabled
                                           className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white focus:ring-2 focus:ring-indigo-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                                    <h1 className={"text-2xl ml-2"} onClick={generatePassword}><IoIosRefreshCircle /></h1>
                                </div>
                            </div>
                            <div className="p-2 w-full">
                                <div className="relative">
                                    <label htmlFor="message" className="leading-7 text-sm text-gray-600">Message</label>
                                    <textarea id="message" name="message"
                                              className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white focus:ring-2 focus:ring-indigo-200 h-32 text-base outline-none text-gray-700 py-1 px-3 resize-none leading-6 transition-colors duration-200 ease-in-out"></textarea>
                                </div>
                            </div>
                            <div className="flex p-2 w-full justify-center bg-blue-50">
                                <Button variant="outline" onClick={() => {
                                    console.log("clicked");
                                    toast({
                                        title: "Scheduled: Catch up ",
                                        description: "Friday, February 10, 2023 at 5:57 PM",
                                        action: (
                                            <ToastAction altText="Goto schedule to undo">Undo</ToastAction>
                                        ),
                                    })
                                }}>Add Teacher</Button>
                            </div>
                            <div className="p-2 w-full pt-8 mt-8 border-t border-gray-200 text-center">
                                <a className="text-indigo-500">example@email.com</a>
                                <p className="leading-normal my-5">49 Smith St.
                                    <br/>Saint Cloud, MN 56301
                                </p>
                                <span className="inline-flex">
          </span>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    );
};

export default Page;