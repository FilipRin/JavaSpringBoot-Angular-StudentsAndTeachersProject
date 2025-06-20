import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ActivityService } from '../../services/activity/activity.service';
import { HttpClient } from '@angular/common/http';
import { PrijavaService } from '../../services/prijava/prijava.service';

@Component({
  selector: 'app-activities',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './activities.component.html',
  styleUrl: './activities.component.css'
})
export class ActivitiesComponent {

  activity: any;
  prijavio : boolean = false;

  constructor(private router: Router, private activityService: ActivityService, 
    private http: HttpClient, private active_route: ActivatedRoute, 
    private prijavaService: PrijavaService) {
  }

  ngOnInit(){
    const id = this.active_route.snapshot.paramMap.get('id');
    if(id){
      const numericId = Number(id);
      this.activityService.getActivity(numericId).subscribe((res:any)=>{
        this.activity = res;
      })

     

      let prijave : any;
      this.prijavaService.getPrijaveByAktivnost(id).subscribe((res)=>{
        prijave = res;
        let userDataString = localStorage.getItem("userData");

        if(userDataString){
          let userData = JSON.parse(userDataString);
          let korisnicko_ime = userData.korisnickoIme;
          prijave.forEach((element : any)=>{
            //console.log(element);
            //console.log(korisnicko_ime);
            if(element.student.korisnickoIme == korisnicko_ime)
            {
              this.prijavio = true;
            }

          } )
        } 
        
      })
      

    }
  }


  prijavi(sala : string){
    //console.log("Prijavi se na aktivnost za salu: " + sala);
    if(this.prijavio){
      return;
    }

    let userDataString = localStorage.getItem("userData");
    if(userDataString){
      let userData = JSON.parse(userDataString);
      let korisnicko_ime = userData.korisnickoIme;
      const prijava ={
        student : {korisnickoIme : korisnicko_ime},
        aktivnost : {id : this.active_route.snapshot.paramMap.get('id')},
        sala: {naziv:sala}
      }
      console.log("Prijava : "+prijava);
      
      this.activityService.createPrijava(prijava).subscribe((res)=>{
        console.log("Uspesno ste se prijavili na aktivnost");
        window.location.reload();
        
      })
    }
  }
  

}
