import { Badge } from "@/components/ui/badge"
import { Progress } from "@/components/ui/progress"

const assignments = [
    { id: 1, name: "Research Paper", course: "Advanced Algorithms", dueDate: "2023-07-15", progress: 75 },
    { id: 2, name: "Database Project", course: "Database Systems", dueDate: "2023-07-20", progress: 30 },
    { id: 3, name: "Web App Prototype", course: "Web Development", dueDate: "2023-07-25", progress: 50 },
    { id: 4, name: "Project Proposal", course: "Machine Learning", dueDate: "2023-08-05", progress: 10 },
]

export function AssignmentsList() {
    return (
        <div className="space-y-4">
            {assignments.map((assignment) => (
                <div key={assignment.id} className="flex items-center justify-between p-4 rounded-lg bg-muted">
                    <div className="space-y-1">
                        <h3 className="font-semibold">{assignment.name}</h3>
                        <p className="text-sm text-muted-foreground">{assignment.course}</p>
                        <div className="flex items-center space-x-2">
                            <Badge variant="outline">Due {assignment.dueDate}</Badge>
                            <Progress value={assignment.progress} className="w-[100px]" />
                            <span className="text-sm font-medium">{assignment.progress}%</span>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
}

