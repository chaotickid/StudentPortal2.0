import {StudentProfile} from "@/app/_components/student-profile";

export default function Home() {
    return (
        <div>
            <div className="ml-[15%]">
                {/*<h1 className="text-3xl font-bold mb-6">Student Profile</h1>*/}
                <StudentProfile/>
            </div>

        </div>
    );
}
