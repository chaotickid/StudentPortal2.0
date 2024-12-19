"use client"

import { useState } from "react"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "@/components/ui/textarea"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { ScrollArea } from "@/components/ui/scroll-area"
import { PenSquare, BookOpen, Trophy, GraduationCap } from 'lucide-react'

// Mock student data (replace with API call in production)
const initialStudentData = {
    name: "Jane Doe",
    id: "ST12345",
    email: "jane.doe@example.com",
    department: "Computer Science",
    year: 3,
    gpa: 3.8,
    credits: 90,
    courses: ["Advanced Algorithms", "Database Systems", "Web Development", "Machine Learning", "Computer Networks", "Software Engineering"],
    achievements: ["Dean's List 2023", "Hackathon Winner 2022", "Best Project Award", "Academic Excellence Scholarship"],
    address: "123 Campus Street, University City, State 12345",
    phoneNumber: "(555) 123-4567",
    dateOfBirth: "1999-05-15",
    advisorName: "Dr. Emily Johnson",
    advisorEmail: "emily.johnson@university.edu"
}

export function StudentProfile() {
    const [studentData, setStudentData] = useState(initialStudentData)
    const [isEditing, setIsEditing] = useState(false)

    const handleInputChange = (e) => {
        const { name, value } = e.target
        setStudentData(prev => ({ ...prev, [name]: value }))
    }

    const handleSave = () => {
        // Here you would typically send the updated data to your backend
        console.log("Saving updated student data:", studentData)
        setIsEditing(false)
    }

    return (
        <div className="space-y-6 max-w-7xl mx-auto">
            <div className="flex justify-between items-center">
                <h1 className="text-3xl font-bold">Profile</h1>
                <Button onClick={() => setIsEditing(!isEditing)} variant="outline">
                    {isEditing ? "Cancel" : "Edit Profile"}
                </Button>
            </div>

            <Card className="overflow-hidden">
                <CardContent className="p-0">
                    <div className="relative h-40 bg-gradient-to-r from-blue-400 to-purple-500">
                        <div className="absolute -bottom-12 left-6">
                            <Avatar className="h-24 w-24 border-4 border-white">
                                <AvatarImage src="/placeholder-avatar.jpg" alt={studentData.name} />
                                <AvatarFallback>{studentData.name.split(' ').map(n => n[0]).join('')}</AvatarFallback>
                            </Avatar>
                        </div>
                    </div>
                    <div className="pt-16 pb-6 px-6">
                        <h2 className="text-2xl font-bold">{studentData.name}</h2>
                        <p className="text-muted-foreground">Student ID: {studentData.id}</p>
                    </div>
                </CardContent>
            </Card>

            <Tabs defaultValue="personal" className="w-full">
                <TabsList className="grid w-full grid-cols-4">
                    <TabsTrigger value="personal" className="flex items-center gap-2">
                        <PenSquare className="h-4 w-4" /> Personal
                    </TabsTrigger>
                    <TabsTrigger value="academic" className="flex items-center gap-2">
                        <GraduationCap className="h-4 w-4" /> Academic
                    </TabsTrigger>
                    <TabsTrigger value="courses" className="flex items-center gap-2">
                        <BookOpen className="h-4 w-4" /> Courses
                    </TabsTrigger>
                    <TabsTrigger value="achievements" className="flex items-center gap-2">
                        <Trophy className="h-4 w-4" /> Achievements
                    </TabsTrigger>
                </TabsList>
                <TabsContent value="personal">
                    <Card>
                        <CardHeader>
                            <CardTitle>Personal Information</CardTitle>
                        </CardHeader>
                        <CardContent className="space-y-4">
                            <EditableField
                                label="Email"
                                name="email"
                                value={studentData.email}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                            />
                            <EditableField
                                label="Phone Number"
                                name="phoneNumber"
                                value={studentData.phoneNumber}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                            />
                            <EditableField
                                label="Date of Birth"
                                name="dateOfBirth"
                                value={studentData.dateOfBirth}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                                type="date"
                            />
                            <EditableField
                                label="Address"
                                name="address"
                                value={studentData.address}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                                multiline
                            />
                        </CardContent>
                    </Card>
                </TabsContent>
                <TabsContent value="academic">
                    <Card>
                        <CardHeader>
                            <CardTitle>Academic Information</CardTitle>
                        </CardHeader>
                        <CardContent className="space-y-4">
                            <EditableField
                                label="Department"
                                name="department"
                                value={studentData.department}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                            />
                            <EditableField
                                label="Year"
                                name="year"
                                value={studentData.year.toString()}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                                type="number"
                            />
                            <EditableField
                                label="GPA"
                                name="gpa"
                                value={studentData.gpa.toString()}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                                type="number"
                                step="0.01"
                            />
                            <EditableField
                                label="Credits Completed"
                                name="credits"
                                value={studentData.credits.toString()}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                                type="number"
                            />
                            <EditableField
                                label="Advisor Name"
                                name="advisorName"
                                value={studentData.advisorName}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                            />
                            <EditableField
                                label="Advisor Email"
                                name="advisorEmail"
                                value={studentData.advisorEmail}
                                isEditing={isEditing}
                                onChange={handleInputChange}
                            />
                        </CardContent>
                    </Card>
                </TabsContent>
                <TabsContent value="courses">
                    <Card>
                        <CardHeader>
                            <CardTitle>Current Courses</CardTitle>
                        </CardHeader>
                        <CardContent>
                            <ScrollArea className="h-[200px] w-full rounded-md border p-4">
                                <ul className="space-y-2">
                                    {studentData.courses.map((course, index) => (
                                        <li key={index} className="flex items-center gap-2">
                                            <BookOpen className="h-4 w-4 text-muted-foreground" />
                                            {course}
                                        </li>
                                    ))}
                                </ul>
                            </ScrollArea>
                        </CardContent>
                    </Card>
                </TabsContent>
                <TabsContent value="achievements">
                    <Card>
                        <CardHeader>
                            <CardTitle>Achievements</CardTitle>
                        </CardHeader>
                        <CardContent>
                            <div className="flex flex-wrap gap-2">
                                {studentData.achievements.map((achievement, index) => (
                                    <Badge key={index} variant="secondary" className="text-sm py-1 px-2">
                                        {achievement}
                                    </Badge>
                                ))}
                            </div>
                        </CardContent>
                    </Card>
                </TabsContent>
            </Tabs>

            {isEditing && (
                <div className="flex justify-end mt-6">
                    <Button onClick={handleSave}>Save Changes</Button>
                </div>
            )}
        </div>
    )
}


function EditableField({ label, name, value, isEditing, onChange, type = "text", step, multiline }) {
    return (
        <div className="space-y-1">
            <Label htmlFor={name} className="text-sm font-medium">{label}</Label>
            {isEditing ? (
                multiline ? (
                    <Textarea
                        id={name}
                        name={name}
                        value={value}
                        onChange={onChange}
                        className="w-full"
                    />
                ) : (
                    <Input
                        type={type}
                        id={name}
                        name={name}
                        value={value}
                        onChange={onChange}
                        step={step}
                    />
                )
            ) : (
                <p className="text-sm text-muted-foreground">{value}</p>
            )}
        </div>
    )
}

