'use client'
import React, {useEffect, useState} from "react";

export default function Home() {

    const [date, setDate] = useState(new Date());

    const events = [
        { title: "Math Club Meeting", date: "2024-12-05", time: "3:00 PM" },
        { title: "Football Match", date: "2024-12-07", time: "5:00 PM" },
        { title: "Student Council Elections", date: "2024-12-10", time: "10:00 AM" }
    ];

    // Example data for announcements
    const announcements = [
        "Final exams will start next week.",
        "The campus library is closed this weekend.",
        "New student health insurance options available.",
        "Important update about student registration deadlines.",
        "Student wellness programs now available at the campus center.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
        "New online courses available for the next semester.",
    ];

    // State for controlling modal visibility
    const [isModalOpen, setIsModalOpen] = useState(false);

    // Function to open the modal
    const openModal = () => {
        setIsModalOpen(true);
        document.body.style.overflow = 'hidden'; // Disable background scrolling
    };

    // Function to close the modal
    const closeModal = () => {
        setIsModalOpen(false);
        document.body.style.overflow = ''; // Re-enable background scrolling
    };

    // Cleanup to enable scrolling when component unmounts
    useEffect(() => {
        return () => {
            document.body.style.overflow = ''; // Ensure background scrolling is re-enabled if component is unmounted
        };
    }, []);


    return (
            <div className="min-h-screen bg-gray-50 ml-[15%] px-5 mt-12">
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    {/* Announcements Section */}
                    <div className="bg-white p-6 rounded-lg shadow-lg">
                        <h2 className="text-2xl font-semibold text-gray-800">Announcements</h2>
                        <ul className="mt-4 space-y-4">
                            {announcements.slice(0, 3).map((announcement, index) => (
                                <li
                                    key={index}
                                    className="bg-gradient-to-r from-indigo-100 to-indigo-50 p-4 rounded-lg shadow-md hover:bg-indigo-200 transition duration-300 ease-in-out"
                                >
                                    <div className="flex items-start space-x-4">
                                        {/* Icon Section */}
                                        <div className="w-12 h-12 bg-indigo-500 text-white rounded-full flex items-center justify-center">
                                            <svg
                                                xmlns="http://www.w3.org/2000/svg"
                                                fill="none"
                                                viewBox="0 0 24 24"
                                                stroke="currentColor"
                                                className="w-6 h-6"
                                            >
                                                <path
                                                    strokeLinecap="round"
                                                    strokeLinejoin="round"
                                                    strokeWidth="2"
                                                    d="M15 12h3m-3 0h-3m3 0l2-2m-2 2l2 2m2-2l-2-2"
                                                />
                                            </svg>
                                        </div>
                                        {/* Text Section */}
                                        <div className="flex-1">
                                            <p className="text-lg font-semibold text-gray-800">{announcement}</p>
                                            <p className="text-sm text-gray-500 mt-2">Posted on: 2024-12-03</p>
                                        </div>
                                    </div>
                                </li>
                            ))}
                        </ul>

                        {/* "See More" Button */}
                        {announcements.length > 3 && (
                            <div className="mt-4 text-center">
                                <button
                                    onClick={openModal}
                                    className="text-indigo-600 hover:text-indigo-800 font-semibold transition duration-300"
                                >
                                    See More
                                </button>
                            </div>
                        )}

                        {/* Modal - Full Announcements  WORKING*/}
                        {/*{isModalOpen && (*/}
                        {/*    <div className="fixed inset-0 bg-gray-900 bg-opacity-70 flex justify-center items-center z-50">*/}
                        {/*        <div*/}
                        {/*            className="bg-white rounded-lg w-[600px] sm:w-[600px] p-6 relative max-h-[80vh] overflow-y-auto transition-transform transform-gpu border shadow-3xl duration-500 ease-in-out"*/}
                        {/*        >*/}

                        {/*            <button*/}
                        {/*                onClick={closeModal}*/}
                        {/*                className="absolute top-4 right-4 text-gray-500 hover:text-gray-700"*/}
                        {/*            >*/}
                        {/*                <svg*/}
                        {/*                    xmlns="http://www.w3.org/2000/svg"*/}
                        {/*                    fill="none"*/}
                        {/*                    viewBox="0 0 24 24"*/}
                        {/*                    stroke="currentColor"*/}
                        {/*                    className="w-6 h-6"*/}
                        {/*                >*/}
                        {/*                    <path*/}
                        {/*                        strokeLinecap="round"*/}
                        {/*                        strokeLinejoin="round"*/}
                        {/*                        strokeWidth="2"*/}
                        {/*                        d="M6 18L18 6M6 6l12 12"*/}
                        {/*                    />*/}
                        {/*                </svg>*/}
                        {/*            </button>*/}

                        {/*            <h2 className="text-2xl font-semibold text-gray-800 mb-4">All Announcements</h2>*/}
                        {/*            <ul className="space-y-4">*/}
                        {/*                {announcements.map((announcement, index) => (*/}
                        {/*                    <li*/}
                        {/*                        key={index}*/}
                        {/*                        className="bg-gradient-to-r from-indigo-100 to-indigo-50 p-4 rounded-lg shadow-md hover:bg-indigo-200 transition duration-300 ease-in-out"*/}
                        {/*                    >*/}
                        {/*                        <div className="flex items-start space-x-4">*/}
                        {/*                            /!* Icon Section *!/*/}
                        {/*                            <div*/}
                        {/*                                className="w-12 h-12 bg-indigo-500 text-white rounded-full flex items-center justify-center">*/}
                        {/*                                <svg*/}
                        {/*                                    xmlns="http://www.w3.org/2000/svg"*/}
                        {/*                                    fill="none"*/}
                        {/*                                    viewBox="0 0 24 24"*/}
                        {/*                                    stroke="currentColor"*/}
                        {/*                                    className="w-6 h-6"*/}
                        {/*                                >*/}
                        {/*                                    <path*/}
                        {/*                                        strokeLinecap="round"*/}
                        {/*                                        strokeLinejoin="round"*/}
                        {/*                                        strokeWidth="2"*/}
                        {/*                                        d="M15 12h3m-3 0h-3m3 0l2-2m-2 2l2 2m2-2l-2-2"*/}
                        {/*                                    />*/}
                        {/*                                </svg>*/}
                        {/*                            </div>*/}
                        {/*                            /!* Text Section *!/*/}
                        {/*                            <div className="flex-1">*/}
                        {/*                                <p className="text-lg font-semibold text-gray-800">{announcement}</p>*/}
                        {/*                                <p className="text-sm text-gray-500 mt-2">Posted on:*/}
                        {/*                                    2024-12-03</p>*/}
                        {/*                            </div>*/}
                        {/*                        </div>*/}
                        {/*                    </li>*/}
                        {/*                ))}*/}
                        {/*            </ul>*/}
                        {/*        </div>*/}
                        {/*    </div>*/}
                        {/*)}*/}


                        {isModalOpen && (
                            <div className="fixed inset-0 bg-gray-900 bg-opacity-70 flex justify-center items-center z-50">
                                <div
                                    className="bg-white rounded-lg w-[600px] sm:w-[600px] p-6 relative max-h-[80vh] overflow-y-auto transition-transform transform-gpu border shadow-3xl duration-500 ease-in-out custom-scrollbar"
                                >
                                    <button
                                        onClick={closeModal}
                                        className="absolute top-4 right-4 text-gray-500 hover:text-gray-700"
                                    >
                                        <svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            fill="none"
                                            viewBox="0 0 24 24"
                                            stroke="currentColor"
                                            className="w-6 h-6"
                                        >
                                            <path
                                                strokeLinecap="round"
                                                strokeLinejoin="round"
                                                strokeWidth="2"
                                                d="M6 18L18 6M6 6l12 12"
                                            />
                                        </svg>
                                    </button>

                                    <h2 className="text-2xl font-semibold text-gray-800 mb-4">All Announcements</h2>
                                    <ul className="space-y-4">
                                        {announcements.map((announcement, index) => (
                                            <li
                                                key={index}
                                                className="bg-gradient-to-r from-indigo-100 to-indigo-50 p-4 rounded-lg shadow-md hover:bg-indigo-200 transition duration-300 ease-in-out"
                                            >
                                                <div className="flex items-start space-x-4">
                                                    {/* Icon Section */}
                                                    <div className="w-12 h-12 bg-indigo-500 text-white rounded-full flex items-center justify-center">
                                                        <svg
                                                            xmlns="http://www.w3.org/2000/svg"
                                                            fill="none"
                                                            viewBox="0 0 24 24"
                                                            stroke="currentColor"
                                                            className="w-6 h-6"
                                                        >
                                                            <path
                                                                strokeLinecap="round"
                                                                strokeLinejoin="round"
                                                                strokeWidth="2"
                                                                d="M15 12h3m-3 0h-3m3 0l2-2m-2 2l2 2m2-2l-2-2"
                                                            />
                                                        </svg>
                                                    </div>
                                                    {/* Text Section */}
                                                    <div className="flex-1">
                                                        <p className="text-lg font-semibold text-gray-800">{announcement}</p>
                                                        <p className="text-sm text-gray-500 mt-2">Posted on: 2024-12-03</p>
                                                    </div>
                                                </div>
                                            </li>
                                        ))}
                                    </ul>
                                </div>
                            </div>
                        )}


                    </div>

                    {/* Events Section */}
                    <div className="bg-white p-6 rounded-lg shadow-lg">
                    <h2 className="text-2xl font-semibold text-gray-800">Upcoming Events</h2>
                        <ul className="mt-4 space-y-2">
                            {events.map((event, index) => (
                                <li key={index} className="text-gray-600">
                                    <strong>{event.title}</strong><br />
                                    <span>{event.date} at {event.time}</span>
                                </li>
                            ))}
                        </ul>
                    </div>

                    {/* Calendar Section */}
                    <div className="bg-white p-6 rounded-lg shadow-lg">
                        <h2 className="text-2xl font-semibold text-gray-800">Calendar</h2>
                        <div className="mt-4 flex justify-center items-center">
                            {/* Simple Calendar */}
                            <div
                                className="w-48 h-48 bg-gray-200 flex items-center justify-center rounded-full text-4xl font-semibold text-gray-700">
                                12
                            </div>
                        </div>
                    </div>
                </div>

                {/* Additional Information or Features */}
                <div className="mt-6">
                    <h2 className="text-2xl font-semibold text-gray-800">Quick Links</h2>
                    <div className="grid grid-cols-2 md:grid-cols-3 gap-4 mt-4">
                        <div className="bg-white p-4 rounded-lg shadow-md text-center">
                            <h3 className="font-semibold text-gray-700">Grades</h3>
                        </div>
                        <div className="bg-white p-4 rounded-lg shadow-md text-center">
                            <h3 className="font-semibold text-gray-700">Assignments</h3>
                        </div>
                        <div className="bg-white p-4 rounded-lg shadow-md text-center">
                            <h3 className="font-semibold text-gray-700">Notifications</h3>
                        </div>
                    </div>
                </div>
            </div>

    );
}

