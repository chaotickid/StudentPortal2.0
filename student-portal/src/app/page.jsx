'use client'
import {Calendar} from "@/components/ui/calendar";
import React, {useState} from "react";
import Card from "@/app/_components/Card";

export default function Home() {
    const [date, setDate] = useState(new Date())
    return (
        <div className={"ml-[15%] px-5 grid grid-cols-4 gap-5"}>

            <div className={"col-span-3"}>
                hi
            </div>

            <div className={"p-5"}>
                <div className={""}>
                    <Calendar
                        mode="single"
                        selected={date}
                        onSelect={setDate}
                        className="rounded-md flex justify-center"
                    />
                </div>



                <div className={"mt-5"}>
                    <h1 className={"text-gray-400"}>Events</h1>
                    <div>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"}></Card>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"}></Card>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"}></Card>

                    </div>
                </div>
                <div className={"mt-5"}>
                    <h1 className={"text-gray-400"}>Announcements</h1>
                    <div>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"} borderColor={"red"}></Card>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"} borderColor={"red"}></Card>
                        <Card name={"Book Fair"} description={"test"} date={"01-01-2025"} borderColor={"red"}></Card>

                    </div>
                </div>


            </div>
        </div>
    );
}

