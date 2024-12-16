'use client'
import React, {useEffect, useState} from "react";

import {cn} from "@/lib/utils";
import {AnimatedList} from "@/components/ui/animated-list";
import {Calendar} from "@/components/ui/calendar";


let notifications = [{
    name: "Payment received", description: "Magic UI", time: "15m ago", icon: "💸", color: "#00C9A7",
}, {
    name: "User signed up", description: "Magic UI", time: "10m ago", icon: "👤", color: "#FFB800",
}, {
    name: "New message", description: "Magic UI", time: "5m ago", icon: "💬", color: "#FF3D71",
}, {
    name: "New event", description: "Magic UI", time: "2m ago", icon: "🗞️", color: "#1E86FF",
},];

notifications = Array.from({length: 10}, () => notifications).flat();

const Notification = ({name, description, icon, color, time}) => {
    return (<figure
        className={cn("relative mx-auto min-h-fit w-full max-w-[400px] cursor-pointer overflow-hidden rounded-2xl p-4", // animation styles
            "transition-all duration-200 ease-in-out hover:scale-[103%]", // light styles
            "bg-white [box-shadow:0_0_0_1px_rgba(0,0,0,.03),0_2px_4px_rgba(0,0,0,.05),0_12px_24px_rgba(0,0,0,.05)]", // dark styles
            "transform-gpu dark:bg-transparent dark:backdrop-blur-md dark:[border:1px_solid_rgba(255,255,255,.1)] dark:[box-shadow:0_-20px_80px_-20px_#ffffff1f_inset]",)}
    >
        <div className="flex flex-row items-center gap-3">
            <div
                className="flex size-10 items-center justify-center rounded-2xl"
                style={{
                    backgroundColor: color,
                }}
            >
                <span className="text-lg">{icon}</span>
            </div>
            <div className="flex flex-col overflow-hidden">
                <figcaption
                    className="flex flex-row items-center whitespace-pre text-lg font-medium dark:text-white ">
                    <span className="text-sm sm:text-lg">{name}</span>
                    <span className="mx-1">·</span>
                    <span className="text-xs text-gray-500">{time}</span>
                </figcaption>
                <p className="text-sm font-normal dark:text-white/60">
                    {description}
                </p>
            </div>
        </div>
    </figure>);
};


export default function Home() {

    const [date, setDate] = useState(new Date());

    const events = [{title: "Math Club Meeting", date: "2024-12-05", time: "3:00 PM"}, {
        title: "Football Match",
        date: "2024-12-07",
        time: "5:00 PM"
    }, {title: "Student Council Elections", date: "2024-12-10", time: "10:00 AM"}];

    // Example data for announcements
    const announcements = ["Final exams will start next week.", "The campus library is closed this weekend.", "New student health insurance options available.", "Important update about student registration deadlines.", "Student wellness programs now available at the campus center.", "New online courses available for the next semester.", "New online courses available for the next semester.", "New online courses available for the next semester.", "New online courses available for the next semester.", "New online courses available for the next semester.", "New online courses available for the next semester.", "New online courses available for the next semester.",];

    // State for controlling modal visibility
    const [isModalOpen, setIsModalOpen] = useState(false);

    // Function to open the modal
    const openModal = () => {
        setIsModalOpen(true);
        document.body.style.overflow = 'hidden'; // Disable background scrolling
    };

    // Function to close the modal
    const closeModal = () => {
        setIsModalOpen(false);
        document.body.style.overflow = ''; // Re-enable background scrolling
    };

    // Cleanup to enable scrolling when component unmounts
    useEffect(() => {
        return () => {
            document.body.style.overflow = ''; // Ensure background scrolling is re-enabled if component is unmounted
        };
    }, []);


    return (
        <section className="text-gray-600 body-font overflow-hidden ml-[15%] px-5">
            <div className="container px-5 py-7 mx-auto">
                <div className="flex flex-wrap -m-12">
                    <div className="p-12 md:w-1/2 flex flex-col items-start">

                        <span
                            className="inline-block py-1 px-2 rounded bg-indigo-50 text-indigo-500 text-xs font-medium tracking-widest">ANNOUNCEMENTS</span>
                        <div className={"grid grid-cols-2 mt-5"}>


                            <div className={"flex bg-green-50 items-center justify-center border rounded-2xl"}>
                                <Calendar
                                    mode="single"
                                    selected={date}
                                    onSelect={setDate}
                                    className="rounded-md border"
                                />
                            </div>

                            <div className={"bg-blue-50"}>
                                <div
                                    className={cn("relative flex h-[500px] w-full flex-col p-6 overflow-hidden rounded-lg bg-background")}>
                                    <AnimatedList>
                                        {notifications.map((item, idx) => (
                                            <Notification {...item} key={idx}/>
                                        ))}
                                    </AnimatedList>
                                </div>
                            </div>

                        </div>


                    </div>
                    <div className="p-12 md:w-1/2 flex flex-col items-start">
                        <span
                            className="inline-block py-1 px-2 rounded bg-indigo-50 text-indigo-500 text-xs font-medium tracking-widest">CATEGORY</span>
                        <h2 className="sm:text-3xl text-2xl title-font font-medium text-gray-900 mt-4 mb-4">Pinterest
                            DIY dreamcatcher gentrify single-origin coffee</h2>
                        <p className="leading-relaxed mb-8">Live-edge letterpress cliche, salvia fanny pack humblebrag
                            narwhal portland. VHS man braid palo santo hoodie brunch trust fund. Bitters hashtag
                            waistcoat fashion axe chia unicorn. Plaid fixie chambray 90's, slow-carb etsy tumeric.</p>
                        <div
                            className="flex items-center flex-wrap pb-4 mb-4 border-b-2 border-gray-100 mt-auto w-full">
                            <a className="text-indigo-500 inline-flex items-center">Learn More
                                <svg className="w-4 h-4 ml-2" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2"
                                     fill="none" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="M5 12h14"></path>
                                    <path d="M12 5l7 7-7 7"></path>
                                </svg>
                            </a>
                            <span
                                className="text-gray-400 mr-3 inline-flex items-center ml-auto leading-none text-sm pr-3 py-1 border-r-2 border-gray-200">
            <svg className="w-4 h-4 mr-1" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round"
                 stroke-linejoin="round" viewBox="0 0 24 24">
              <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
              <circle cx="12" cy="12" r="3"></circle>
            </svg>1.2K
          </span>
                            <span className="text-gray-400 inline-flex items-center leading-none text-sm">
            <svg className="w-4 h-4 mr-1" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round"
                 stroke-linejoin="round" viewBox="0 0 24 24">
              <path
                  d="M21 11.5a8.38 8.38 0 01-.9 3.8 8.5 8.5 0 01-7.6 4.7 8.38 8.38 0 01-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 01-.9-3.8 8.5 8.5 0 014.7-7.6 8.38 8.38 0 013.8-.9h.5a8.48 8.48 0 018 8v.5z"></path>
            </svg>6
          </span>
                        </div>
                        <a className="inline-flex items-center">
                            <img alt="blog" src="https://dummyimage.com/103x103"
                                 className="w-12 h-12 rounded-full flex-shrink-0 object-cover object-center"/>
                            <span className="flex-grow flex flex-col pl-4">
            <span className="title-font font-medium text-gray-900">Alper Kamu</span>
            <span className="text-gray-400 text-xs tracking-widest mt-0.5">DESIGNER</span>
          </span>
                        </a>
                    </div>
                </div>
            </div>
        </section>

    );
}

