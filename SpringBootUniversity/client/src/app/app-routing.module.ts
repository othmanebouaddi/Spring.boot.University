import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentInterfaceComponent } from './student-interface/student-interface.component';
import { ProfInterfaceComponent } from './prof-interface/prof-interface.component';
import { AdministrationInterfaceComponent } from './administration-interface/administration-interface.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { StudentComponent } from './student/student.component';
import { ProfComponent } from './prof/prof.component';
import { ProgramComponent } from './program/program.component';
import { CoursComponent } from './cours/cours.component';
import { GroupecoursComponent } from './groupecours/groupecours.component';
import { ProgramCoursComponent } from './program-cours/program-cours.component';
import { InterfaceProgramcoursComponent } from './interface-programcours/interface-programcours.component';
import { InterfaceCoursComponent } from './interface-cours/interface-cours.component';


const routes: Routes = [
  { path: '', component: WelcomePageComponent },
  { path: 'student', component: StudentInterfaceComponent },
  { path: 'programcours/:programId', component: InterfaceProgramcoursComponent },
  { path: 'cours/:initials', component: InterfaceCoursComponent },
  { path: 'professor', component: ProfInterfaceComponent },
  { path: 'administration', component: AdministrationInterfaceComponent },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [ StudentComponent, ProfComponent, ProgramComponent, CoursComponent, GroupecoursComponent, StudentInterfaceComponent, ProfInterfaceComponent, AdministrationInterfaceComponent, WelcomePageComponent, PageNotFoundComponent, ProgramCoursComponent, InterfaceProgramcoursComponent, InterfaceCoursComponent]


  
  
  
  