'use client'
import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";
import {Button} from "@/components/ui/button";
import {BarChart, Bell, BookOpen, Clock, GraduationCap} from "lucide-react";
import {Card, CardContent, CardDescription, CardHeader, CardTitle} from "@/components/ui/card";
import {Progress} from "@/components/ui/progress";
import {StudentCalendar} from "@/app/_components/student-calendar";
import {RecentAnnouncements} from "@/app/_components/recent-announcement";
import {AssignmentsList} from "@/app/_components/assignments-list";
import {GradesOverview} from "@/app/_components/grades-overview";
import {UpcomingClasses} from "@/app/_components/upcoming-classes";
import {useState} from "react";

const calendarEvents = [
    { date: new Date(2023, 6, 15), type: 'assignment', title: 'Research Paper Due', course: 'Advanced Algorithms' },
    { date: new Date(2023, 6, 20), type: 'exam', title: 'Midterm Exam', course: 'Database Systems' },
    { date: new Date(2023, 6, 25), type: 'assignment', title: 'Web App Prototype Due', course: 'Web Development' },
    { date: new Date(2023, 7, 1), type: 'event', title: 'Fall Semester Begins' },
    { date: new Date(2023, 7, 5), type: 'assignment', title: 'Project Proposal Due', course: 'Machine Learning' },
]

export function StudentDashboard() {
    const [selectedDate, setSelectedDate] = useState(new Date())

    return (
        <div className="container mx-auto p-6 space-y-6">
            <header className="flex justify-between items-center mb-6">
                <div className="flex items-center space-x-4">
                    <Avatar className="h-12 w-12">
                        <AvatarImage src="/placeholder-avatar.jpg" alt="Student"/>
                        <AvatarFallback>JD</AvatarFallback>
                    </Avatar>
                    <div>
                        <h1 className="text-2xl font-bold">Welcome back, Aditya!</h1>
                        <p className="text-muted-foreground">It's a great day to learn something new.</p>
                    </div>
                </div>
                <Button variant="outline" size="icon">
                    <Bell className="h-4 w-4"/>
                </Button>
            </header>

            <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-4">
                <Card>
                    <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
                        <CardTitle className="text-sm font-medium">Total Credits</CardTitle>
                        <GraduationCap className="h-4 w-4 text-muted-foreground"/>
                    </CardHeader>
                    <CardContent>
                        <div className="text-2xl font-bold">78/120</div>
                        <Progress value={65} className="mt-2"/>
                        <p className="text-xs text-muted-foreground mt-2">65% completed</p>
                    </CardContent>
                </Card>
                <Card>
                    <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
                        <CardTitle className="text-sm font-medium">Current GPA</CardTitle>
                        <BarChart className="h-4 w-4 text-muted-foreground"/>
                    </CardHeader>
                    <CardContent>
                        <div className="text-2xl font-bold">3.8</div>
                        <p className="text-xs text-muted-foreground mt-2">+0.2 from last semester</p>
                    </CardContent>
                </Card>
                <Card>
                    <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
                        <CardTitle className="text-sm font-medium">Upcoming Assignments</CardTitle>
                        <BookOpen className="h-4 w-4 text-muted-foreground"/>
                    </CardHeader>
                    <CardContent>
                        <div className="text-2xl font-bold">7</div>
                        <p className="text-xs text-muted-foreground mt-2">3 due this week</p>
                    </CardContent>
                </Card>
                <Card>
                    <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
                        <CardTitle className="text-sm font-medium">Study Hours</CardTitle>
                        <Clock className="h-4 w-4 text-muted-foreground"/>
                    </CardHeader>
                    <CardContent>
                        <div className="text-2xl font-bold">24.5</div>
                        <p className="text-xs text-muted-foreground mt-2">This week</p>
                    </CardContent>
                </Card>
            </div>

            <div className="grid gap-6 md:grid-cols-2">
                <Card>
                    <CardHeader>
                        <CardTitle>Upcoming Classes</CardTitle>
                        <CardDescription>Your schedule for today</CardDescription>
                    </CardHeader>
                    <CardContent>
                        <UpcomingClasses/>
                    </CardContent>
                </Card>
                <Card>
                    <CardHeader>
                        <CardTitle>Academic Calendar</CardTitle>
                        <CardDescription>Manage your schedule and deadlines</CardDescription>
                    </CardHeader>
                    <CardContent className="flex justify-center">
                        <StudentCalendar
                            events={calendarEvents}
                            selected={selectedDate}
                            onSelect={setSelectedDate}
                        />
                    </CardContent>
                </Card>
            </div>

            <div className="grid gap-6 md:grid-cols-2">
                <Card>
                    <CardHeader>
                        <CardTitle>Recent Announcements</CardTitle>
                        <CardDescription>Stay updated with the latest news</CardDescription>
                    </CardHeader>
                    <CardContent>
                        <RecentAnnouncements/>
                    </CardContent>
                </Card>
                <Card>
                    <CardHeader>
                        <CardTitle>Assignments</CardTitle>
                        <CardDescription>Track your upcoming work</CardDescription>
                    </CardHeader>
                    <CardContent>
                        <AssignmentsList/>
                    </CardContent>
                </Card>
            </div>

            <Card>
                <CardHeader>
                    <CardTitle>Grades Overview</CardTitle>
                    <CardDescription>Your academic performance at a glance</CardDescription>
                </CardHeader>
                <CardContent>
                    <GradesOverview/>
                </CardContent>
            </Card>
        </div>
    )
}