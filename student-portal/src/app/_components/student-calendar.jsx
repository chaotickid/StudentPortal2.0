import {Calendar} from "@/components/ui/calendar";
import {ScrollArea} from "@/components/ui/scroll-area";
import {Card, CardContent} from "@/components/ui/card";
import {Badge} from "@/components/ui/badge";
import {useState} from "react";


export function StudentCalendar({ events, selected, onSelect }) {

    const [hoveredDate, setHoveredDate] = useState(null)

    const eventDates = events.reduce((acc, event) => {
        const dateString = event.date.toDateString()
        if (!acc[dateString]) {
            acc[dateString] = []
        }
        acc[dateString].push(event)
        return acc
    })

    const getDateContent = (date) => {
        const dateString = date.toDateString()
        if (eventDates[dateString]) {
            return (
                <div className="w-full h-full flex items-center justify-center">
                    <Badge variant="secondary" className="w-1.5 h-1.5 p-0 rounded-full" />
                </div>
            )
        }
        return null
    }

    const selectedDateEvents = selected ? eventDates[selected.toDateString()] || [] : []

    // Dummy events generator
    const generateDummyEvents = (date) => {
        const types = ['assignment', 'exam', 'event'];
        const courses = ['Mathematics', 'Physics', 'Computer Science', 'Literature', 'History'];
        const eventCount = Math.floor(Math.random() * 3) + 1; // 1 to 3 events

        return Array.from({ length: eventCount }, (_, i) => ({
            date: date,
            type: types[Math.floor(Math.random() * types.length)],
            title: `Dummy ${types[Math.floor(Math.random() * types.length)]} ${i + 1}`,
            course: courses[Math.floor(Math.random() * courses.length)],
        }));
    };
    return (
        <div className="flex flex-col items-center space-y-4">
            <Calendar
                mode="single"
                selected={selected}
                onSelect={(date) => {
                    onSelect(date)
                    if (date && !eventDates[date.toDateString()]) {
                        eventDates[date.toDateString()] = generateDummyEvents(date)
                    }
                }}
                className="rounded-md border"
                components={{
                    DayContent: (props) => (
                        <div
                            onMouseEnter={() => setHoveredDate(props.date)}
                            onMouseLeave={() => setHoveredDate(null)}
                        >
                            {props.date.getDate()}
                            {getDateContent(props.date)}
                        </div>
                    )
                }}
            />
            <ScrollArea className="h-[200px] w-full">
                <Card>
                    <CardContent>
                        {selected && (
                            <div>
                                <h3>Events on {selected.toLocaleDateString()}:</h3>
                                {(eventDates[selected.toDateString()] || []).map((event, index) => (
                                    <div key={index}>
                                        <Badge>{event.type}</Badge>
                                        <p>{event.title}</p>
                                        {event.course && <p>{event.course}</p>}
                                    </div>
                                ))}
                            </div>
                        )}
                    </CardContent>
                </Card>
            </ScrollArea>
        </div>
    )
}