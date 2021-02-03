export interface UserRegisteredResponse
{
    id?:number;
    firstName?: string;
    lastName?: string;
    username?: string;
    password?: string;
    email?: string;
    administrator?: boolean;
}