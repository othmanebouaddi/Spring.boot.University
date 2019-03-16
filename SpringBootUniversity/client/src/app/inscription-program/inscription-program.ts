import { Student } from "../student/student";
import { Program } from "../program/program";

export interface InscriptionProgram {

	id : number;
	student : Student;
	program : Program;
	MoyenProgram : number;
	DateInscription: string;
	student_program_id: number;


}
