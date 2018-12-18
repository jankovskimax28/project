import {Role} from  "./Role";

export class User {
  id: string;
  login: string;
  password: string;
  email: string;
  roleId: string;
  roleByRoleId:  Role;
}
