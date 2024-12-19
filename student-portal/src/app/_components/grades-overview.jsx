const grades = [
    { id: 1, course: "Advanced Algorithms", grade: "A", percentage: 92 },
    { id: 2, course: "Database Systems", grade: "B+", percentage: 88 },
    { id: 3, course: "Web Development", grade: "A-", percentage: 90 },
    { id: 4, course: "Machine Learning", grade: "B", percentage: 85 },
]

export function GradesOverview() {
    return (
        <div className="space-y-4">
            {grades.map((grade) => (
                <div key={grade.id} className="flex items-center justify-between p-4 rounded-lg bg-muted">
                    <div>
                        <h3 className="font-semibold">{grade.course}</h3>
                        <p className="text-sm text-muted-foreground">Current Grade: {grade.grade}</p>
                    </div>
                    <div className="text-2xl font-bold">{grade.percentage}%</div>
                </div>
            ))}
        </div>
    )
}

