import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeStudentComponent } from './components/student/home-student/home-student.component';
import { HomeTeacherComponent } from './components/teacher/home-teacher/home-teacher.component';
import { ActivitiesComponent } from './components/activities/activities.component';

export const routes: Routes = [
    {path: 'login', component : LoginComponent},
    {path: 'student/home', component : HomeStudentComponent},
    {path : 'nastavnik/home', component: HomeTeacherComponent},
    {path: 'activity/:id', component : ActivitiesComponent},

];
