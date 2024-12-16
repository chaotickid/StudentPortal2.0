import React from 'react';
import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableFooter,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"
import {DeleteIcon, Pencil, ViewIcon} from "lucide-react";
import DialogueBox from "@/app/_components/DialogueBox";
import CustomPegination from "@/app/_components/CustomPegination";
import {SiGooglemeet} from "react-icons/si";

const Page = () => {

    const invoices = [
        {
            id: "INV002",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <ViewIcon/>,
            joiningLink: "https://meet.google.com/upy-jkwq-ctx",
            classTiming: "4:00 PM - 7:00PM",
            updateIcon: <Pencil/>,
            deleteIcon: <DeleteIcon/>,
            classStatus: true,
        },
        {
            id: "INV001",
            name: "Invoice 1",
            email: "invoice@example.com",
            joiningLink: "https://meet.google.com/upy-jkwq-ctx",
            classTiming: "4:00 PM - 7:00PM",
            viewIcon: <ViewIcon/>,
            updateIcon: <Pencil/>,
            deleteIcon: <DeleteIcon/>,
            classStatus: false,
        },
        {
            id: "INV003",
            name: "Invoice 1",
            email: "invoice@example.com",
            joiningLink: "https://meet.google.com/upy-jkwq-ctx",
            classTiming: "4:00 PM - 7:00PM",
            viewIcon: <ViewIcon/>,
            deleteIcon: <DeleteIcon/>,
            updateIcon: <Pencil/>,
            classStatus: false,
        }
    ]
    return (
        <div className={"ml-[15%] px-5"}>
            <DialogueBox
                ButtonName={"Add Class"}
                DialogueTitle={"Add Class"}
                DialogDescription={"Please fill out the details below to add a new class"}
                className={"mb-10"}></DialogueBox>

            <Table>
                <TableCaption>A list of class.</TableCaption>
                <TableHeader>
                    <TableRow>
                        <TableHead className="w-[100px]">Id</TableHead>
                        <TableHead>Name</TableHead>
                        <TableHead>Email</TableHead>
                        <TableHead>Joining Link</TableHead>
                        <TableHead>Class Timing</TableHead>
                        <TableHead className={"text-center"}>Class Status</TableHead>
                        <TableHead className={"text-center"}>Actions</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {invoices.map((invoice) => (
                        <TableRow key={invoice.id}>
                            <TableCell className="font-medium">{invoice.id}</TableCell>
                            <TableCell>{invoice.name}</TableCell>
                            <TableCell>{invoice.email}</TableCell>
                            <TableCell>
                                <div className={"flex items-center gap-5"}>
                                    <h1 className={"text-green-800"}><SiGooglemeet/></h1>
                                    <a href={invoice.joiningLink}  target="_blank" rel="noopener noreferrer"
                                       className={"cursor-pointer hover:text-blue-800 hover:underline"}>{invoice.joiningLink}</a>
                                </div>

                            </TableCell>
                            <TableCell>{invoice.classTiming}</TableCell>
                            <TableCell>{invoice.classStatus ?
                                <h1 className={"border p-2 bg-red-500 text-center font-bold text-white"}>ON AIR</h1>
                                :
                                <h1 className={"border p-2 bg-green-100 text-center font-bold text-green-800"}>RECORDED</h1>}</TableCell>
                            <TableCell>
                                <div className={"flex items-center justify-center gap-5 cursor-pointer"}>
                                    <DialogueBox
                                        icon={<h1>{invoice.viewIcon}</h1>}
                                        DialogueTitle={"View class Details"}
                                        DialogDescription={"Please fill out the details below to add a new class"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1>{invoice.updateIcon}</h1>}
                                        DialogueTitle={"View class Details"}
                                        DialogDescription={"Please fill out the details below to add a new class"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1>{invoice.deleteIcon}</h1>}
                                        DialogueTitle={"Delete class"}
                                        DialogDescription={"This action cannot be undone. This will permanently delete your account and remove your data from our servers."}
                                        className={"mb-10"}></DialogueBox>
                                </div>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TableCell colSpan={7}>
                            <CustomPegination></CustomPegination>
                        </TableCell>
                    </TableRow>
                </TableFooter>
            </Table>
        </div>
    );
};

export default Page;