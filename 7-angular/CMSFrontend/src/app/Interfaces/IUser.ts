import { ICourse } from "./ICourse";

export interface IUser{
    id?:number;
    first?:string;
    last?:string;
    email?:string;
    username?:string;
    password?:string;
    courses?:ICourse[];
}