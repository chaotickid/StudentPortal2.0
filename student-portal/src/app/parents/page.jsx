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

const Page = () => {

    const invoices = [
        {
            id: "INV002",
            name: "Invoice 1",
            email: "invoice@example.com",
           viewIcon: <ViewIcon/>,
           updateIcon: <Pencil />,
            deleteIcon: <DeleteIcon/>,
            accountStatus: true,
        },
        {
            id: "INV001",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <ViewIcon/>,
            updateIcon: <Pencil />,
            deleteIcon: <DeleteIcon />,
            accountStatus: false,
        },
        {
            id: "INV003",
            name: "Invoice 1",
            email: "invoice@example.com",
            viewIcon: <ViewIcon/>,
            deleteIcon: <DeleteIcon/>,
            updateIcon: <Pencil />,
            accountStatus: false,
        }
    ]
    return (
        <div className={"ml-[15%] px-5"}>
            <DialogueBox
                ButtonName={"Add Parent"}
                DialogueTitle={"Add Parent"}
                DialogDescription={"Please fill out the details below to add a new teacher"}
                className={"mb-10"}></DialogueBox>

            <Table>
                <TableCaption>A list of teachers.</TableCaption>
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
                                       icon={<h1>{invoice.viewIcon}</h1>}
                                       DialogueTitle={"View Teacher Details"}
                                        DialogDescription={"Please fill out the details below to add a new teacher"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1>{invoice.updateIcon}</h1>}
                                        DialogueTitle={"View Teacher Details"}
                                        DialogDescription={"Please fill out the details below to add a new teacher"}
                                        className={"mb-10"}></DialogueBox>
                                    <DialogueBox
                                        icon={<h1>{invoice.deleteIcon}</h1>}
                                        DialogueTitle={"Delete Teacher"}
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