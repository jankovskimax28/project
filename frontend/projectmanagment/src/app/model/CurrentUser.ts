import {Role} from "./Role";

export class CurrentUser {

  id: string;
  login: string;
  password: string;
  email: string;
  roleId: string;
  roleByRoleId:  Role;

}
