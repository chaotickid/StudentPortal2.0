import { Badge } from "@/components/ui/badge"

const classes = [
    { id: 1, name: "Advanced Algorithms", time: "10:00 AM - 11:30 AM", location: "Room 301", type: "Lecture" },
    { id: 2, name: "Database Systems", time: "1:00 PM - 2:30 PM", location: "Lab 2B", type: "Lab" },
    { id: 3, name: "Web Development", time: "3:00 PM - 4:30 PM", location: "Room 205", type: "Workshop" },
]

export function UpcomingClasses() {
    return (
        <div className="space-y-4">
            {classes.map((cls) => (
                <div key={cls.id} className="flex items-center justify-between p-4 rounded-lg bg-muted">
                    <div>
                        <h3 className="font-semibold">{cls.name}</h3>
                        <p className="text-sm text-muted-foreground">{cls.time}</p>
                        <p className="text-sm text-muted-foreground">{cls.location}</p>
                    </div>
                    <Badge variant={cls.type === "Lecture" ? "default" : cls.type === "Lab" ? "secondary" : "outline"}>
                        {cls.type}
                    </Badge>
                </div>
            ))}
        </div>
    )
}

