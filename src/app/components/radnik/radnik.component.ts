import { Component, OnDestroy, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Radnik } from 'src/app/models/radnik';
import { Sektor } from 'src/app/models/sektor';
import { RadnikService } from 'src/app/services/radnik.service';
import { RadnikDialogComponent } from '../dialogs/radnik-dialog/radnik-dialog.component';

@Component({
  selector: 'app-radnik',
  templateUrl: './radnik.component.html',
  styleUrls: ['./radnik.component.css']
})
export class RadnikComponent implements OnInit, OnDestroy {

  displayedColumns = ['id', 'ime', 'prezime','brojLk', 'sektor', 'actions']; //obrazovanje!!!!
  dataSource: MatTableDataSource<Radnik>;
  subscription: Subscription;

  constructor(private radnikService: RadnikService,
    private dialog: MatDialog) { }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.radnikService.getAllRadnici().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      }
  }

  public openDialog(flag: number, id?: number, ime?:string, prezime?: string, brojLk?: number, sektor?:Sektor) { //obrazovanje?:Obrazovanje
    const dialogRef = this.dialog.open(RadnikDialogComponent, 
      {data: {
        id,ime,prezime,brojLk,sektor
      }});
    dialogRef.componentInstance.flag = flag; 
    dialogRef.afterClosed().subscribe(res => {
      if(res === 1)
      {
        this.loadData();
      }
    })
  }
  selectRow(row: any){
    console.log(row);
  }

}
