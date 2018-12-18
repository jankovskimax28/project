import {Priority} from "./Priority";
import {User} from "./User"
import {Project} from "./Project";
import {Status} from "./Status"


export  class Task{

  id: string;
  reporter: string;
  ticetCode: string;
  status: string;
  priority: string;
  estimation: string;
  attacment: string;
  comment: string;
  description: string;
  assignee: string;
  projectId: string;
  dueDate: string;
  statusByStatus: Status;
  priorityByPriority: Priority;
  userByReporter: User;
  userByAssignee: User;
  projectByProjectId: Project;
  createDate: String;
  updateDate: number;

}
