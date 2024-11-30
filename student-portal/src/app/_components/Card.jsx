export default function Card({name, description, date, borderColor}) {
    return (
        <div
            className={`mt-5 border ${borderColor ? `border-${borderColor}-50` : 'border-blue-50'}  border-t-4 p-2 text-gray-400 cursor-pointer hover:bg-blue-50 transition ease-in-out duration-200 shadow-md`}
        >
            <div className="flex justify-between">
                <h1 className="font-bold">{name}</h1>
                <h1>{date}</h1>
            </div>

            <h1>{description}</h1>
        </div>
    );
}