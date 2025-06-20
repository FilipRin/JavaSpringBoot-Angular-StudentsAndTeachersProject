import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth/auth.service';
import { Router, RouterModule } from '@angular/router';
import { ActivityService } from '../../../services/activity/activity.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-home-teacher',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './home-teacher.component.html',
  styleUrl: './home-teacher.component.css'
})
export class HomeTeacherComponent {


  userData: any;

  myActivities : any;

  activityForm : FormGroup

  constructor(private router: Router, private activityService : ActivityService, 
    private fb: FormBuilder
  ){
    this.activityForm = this.fb.group({
      naziv: ['', Validators.required],
      datum_vreme: ['', Validators.required],
      sala1: [false],
      sala2: [false],
      sala3: [false]
    })

  }

  ngOnInit(){
    const storedData = localStorage.getItem('userData');
    if(storedData){
      this.userData = JSON.parse(storedData)
      this.activityService.getNastavnikActivities(this.userData.korisnickoIme).subscribe((data: any)=>{
        this.myActivities = data;
        console.log("My activities: ", data);
        
      })
    }
  }

  logout(){
    AuthService.logout();
    this.router.navigate(['/login'])

  }

  promeniStatus(id : number){
    this.activityService.changeActivityStatus(id).subscribe((data)=>{
      console.log("Status promenjen");
    })
    window.location.reload();
    
  } 

  salaSelections = {sala1: false, sala2: false, sala3: false}

  addActivity(){
    const formValue = this.activityForm.value;
    
    const storedData = localStorage.getItem('userData');
    if(storedData){
      const nastavnik = JSON.parse(storedData).korisnickoIme;
      const requestData = {
        naziv : formValue.naziv,
        datum_vreme : formValue.datum_vreme,
        sala1 : formValue.sala1 ? 5 : -1,
        sala2 : formValue.sala2 ? 5 : -1,
        sala3 : formValue.sala3 ? 2 : -1,
        napravio: {
          korisnickoIme: nastavnik
        } 
      }
      this.activityService.addActivity(requestData).subscribe((data)=>{
        console.log("Activity added: ", data);
        window.location.reload();
      })
    }


    
  }

}
