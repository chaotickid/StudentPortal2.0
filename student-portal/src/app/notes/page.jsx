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
import {DeleteIcon, DownloadIcon, Pencil, ViewIcon} from "lucide-react";
import DialogueBox from "@/app/_components/DialogueBox";
import CustomPegination from "@/app/_components/CustomPegination";
import { IoIosCloudDownload } from "react-icons/io";
import { MdDelete } from "react-icons/md";
import { MdEdit } from "react-icons/md";
import { HiOutlineViewfinderCircle } from "react-icons/hi2";

const Page = () => {

    const invoices = [
        {
            id: "INV002",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <HiOutlineViewfinderCircle />,
            updateIcon: <MdEdit />,
            deleteIcon: <MdDelete/>,
            downloadIcon: <IoIosCloudDownload/>,
            accountStatus: true,
        },
        {
            id: "INV001",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <HiOutlineViewfinderCircle/>,
            updateIcon: <MdEdit />,
            deleteIcon: <MdDelete />,
            downloadIcon: <IoIosCloudDownload/>,
            accountStatus: false,
        },
        {
            id: "INV003",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <HiOutlineViewfinderCircle/>,
            deleteIcon: <MdDelete/>,
            updateIcon: <MdEdit />,
            downloadIcon: <IoIosCloudDownload/>,
            accountStatus: false,
        }
    ]
    return (
        <div className={"ml-[15%] px-5"}>
            <DialogueBox
                ButtonName={"Upload notes"}
                DialogueTitle={"Add Student"}
                DialogDescription={"Please fill out the details below to add a new student"}
                className={"mb-10"}></DialogueBox>

            <Table>
                <TableCaption>A list of students.</TableCaption>
                <TableHeader>
                    <TableRow>
                        <TableHead className="w-[100px]">Id</TableHead>
                        <TableHead>Name</TableHead>
                        <TableHead>Email</TableHead>
                        <TableHead className={"text-center"}>Account Status</TableHead>
                        <TableHead className={"text-center"}>Actions</TableHead>
                    </TableRow>
                </TableHeader>
                <TableBody>
                    {invoices.map((invoice) => (
                        <TableRow key={invoice.id}>
                            <TableCell className="font-medium">{invoice.id}</TableCell>
                            <TableCell>{invoice.name}</TableCell>
                            <TableCell>{invoice.email}</TableCell>
                            <TableCell>{invoice.accountStatus ?
                                <h1 className={"border p-2 bg-green-100 text-center font-bold text-green-800"}>ACTIVE</h1>
                                :
                                <h1 className={"border p-2 bg-orange-100 text-center font-bold text-orange-800"}>INACTIVE</h1>}</TableCell>
                            <TableCell>
                                <div className={"flex items-center justify-center gap-5 cursor-pointer"}>
                                    <DialogueBox
                                        icon={<h1 className={"text-3xl"}>{invoice.viewIcon}</h1>}
                                        DialogueTitle={"View student Details"}
                                        DialogDescription={"Please fill out the details below to add a new student"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1 className={"text-2xl"}>{invoice.updateIcon}</h1>}
                                        DialogueTitle={"View student Details"}
                                        DialogDescription={"Please fill out the details below to add a new student"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1 className={"text-2xl"}>{invoice.deleteIcon}</h1>}
                                        DialogueTitle={"Delete student"}
                                        DialogDescription={"This action cannot be undone. This will permanently delete your account and remove your data from our servers."}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1 className={"text-2xl"}>{invoice.downloadIcon}</h1>}
                                        DialogueTitle={"Download Notes"}
                                        DialogDescription={"This action cannot be undone. This will permanently delete your account and remove your data from our servers."}
                                        className={"mb-10"}></DialogueBox>
                                </div>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TableCell colSpan={5}>
                            <CustomPegination></CustomPegination>
                        </TableCell>

                    </TableRow>
                </TableFooter>
            </Table>
        </div>
    );
};

export default Page;