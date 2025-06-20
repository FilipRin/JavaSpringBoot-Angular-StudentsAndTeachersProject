import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth/auth.service';
import { Router, RouterModule } from '@angular/router';
import { ActivityService } from '../../../services/activity/activity.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-home-student',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './home-student.component.html',
  styleUrl: './home-student.component.css'
})
export class HomeStudentComponent {

  userData: any;
  activeActivities : any;

  constructor(private router: Router, private activityService: ActivityService, 
    private http: HttpClient) {}

  ngOnInit(){
    const storedData = localStorage.getItem('userData');
    if(storedData){
      this.userData = JSON.parse(storedData)
    }

    this.activityService.getActiveActivities().subscribe((res: any)=>{
      this.activeActivities = res;
    })

  }

  logout(){
    AuthService.logout();
    this.router.navigate(['/login'])

  }
  

}
