import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"

const announcements = [
    {
        id: 1,
        title: "New Course Registration Open",
        content: "Registration for Fall 2024 courses is now open. Please check your eligibility and register before July 31st.",
        author: "Registrar's Office",
        date: "2 days ago",
        avatar: "/placeholder-avatar.jpg",
    },
    {
        id: 2,
        title: "Campus Career Fair",
        content: "Don't miss our annual Career Fair on August 15th. Over 50 companies will be present.",
        author: "Career Services",
        date: "1 week ago",
        avatar: "/placeholder-avatar.jpg",
    },
]

export function RecentAnnouncements() {
    return (
        <div className="space-y-4">
            {announcements.map((announcement) => (
                <div key={announcement.id} className="flex space-x-4 items-start">
                    <Avatar className="mt-1">
                        <AvatarImage src={announcement.avatar} alt={announcement.author} />
                        <AvatarFallback>{announcement.author[0]}</AvatarFallback>
                    </Avatar>
                    <div>
                        <h3 className="font-semibold">{announcement.title}</h3>
                        <p className="text-sm text-muted-foreground">{announcement.content}</p>
                        <div className="flex items-center mt-1 space-x-2">
                            <span className="text-xs font-medium">{announcement.author}</span>
                            <span className="text-xs text-muted-foreground">{announcement.date}</span>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

