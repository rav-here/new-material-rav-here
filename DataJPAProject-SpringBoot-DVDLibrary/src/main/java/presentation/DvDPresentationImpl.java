package presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.DvD;
import service.DvDService;

@Component("presentation")
public class DvDPresentationImpl implements DvDPresentation{

	// presentation will pass request to service layer for all business logic actions
		private DvDService dvdService;
		// setter 
		@Autowired
		public void setDvDService(DvDService dvdService) {
			this.dvdService = dvdService;
		}
	
	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("DvD Library System");
		System.out.println("1. List All DvDs");
		System.out.println("2. Search DvD By ID");
		System.out.println("3. Add New DvD");
		System.out.println("4. Delete a DvD");
		System.out.println("5. Edit a DvD");
		System.out.println("6. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
Scanner scanner = new Scanner(System.in);
		
		switch (choice) {
		
		case 1: 
			Collection<DvD> dvds= dvdService.getAllDvDs();
			for(DvD dvd : dvds) {
				System.out.println(dvd);
			}
			break;
		
		case 2: 
			System.out.println("Enter DvD Id : ");
			int id=scanner.nextInt();
			DvD dvd= dvdService.searchDvDbyID(id);
			if(dvd != null)
				System.out.println(dvd);
			else
				System.out.println("DvD with id "+id+" does not exist");
			break;
		
		case 3:
            DvD newDvd=new DvD();

            System.out.println("Enter DvD Id : ");
            newDvd.setId(scanner.nextInt());
            scanner.nextLine();
            
            System.out.println("Enter DvD Title : ");
            newDvd.setTitle(scanner.nextLine());
            
            System.out.println("Enter DvD Release Date (yyyy-mm-dd) : ");
            String strDate = scanner.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd");
            LocalDate date = LocalDate.parse(strDate, dtf);
            newDvd.setReleaseDate(date);
            
            System.out.println("Enter DvD Director : ");
            newDvd.setDirector(scanner.nextLine());
            
            System.out.println("Enter DvD Rating : ");
            newDvd.setRating(scanner.nextLine());
            
            System.out.println("Enter DvD Studio : ");
            newDvd.setStudio(scanner.nextLine());
            
            System.out.println("Enter DvD Duration : ");
            newDvd.setDuration(scanner.nextDouble());
            
            if(dvdService.addDvD(newDvd))
            System.out.println("DvD Record Added");
            else
            System.out.println("DvD with id "+newDvd.getId()+" already exist, so cannot add it as a new DvD!");

            break;		
        
		case 4: 
			System.out.println("Enter DvD Id : ");
			int Id = scanner.nextInt();
			if (dvdService.deleteDvD(Id) == 1) {
				System.out.println("DvD with Id "+Id+" deleted");
			}
			else { 
				System.out.println("DvD with Id "+Id+" does not exist");
			}
			break;
            
		case 5: 
			System.out.println("Enter DvD ID : ");
			int dvdId = scanner.nextInt();
			DvD theDvD = dvdService.searchDvDbyID(dvdId);
			
			if (dvdService.editDvD(dvdId)) {
				System.out.println("Enter the DvD field you want to edit (id, title, date, director, rating, studio, duration) : ");
				String input = scanner.next();
				scanner.nextLine();
				
				if (input.equals("id")) {
					System.out.println("Enter new DvD Id : ");
					theDvD.setId(scanner.nextInt());;
				}
				else if (input.equals("title")) {
					System.out.println("Enter new DvD Title : ");
					theDvD.setTitle(scanner.nextLine());;
				}
				else if (input.equals("date")) {
					System.out.println("Enter new DvD Release Date : ");
					String date1 = scanner.nextLine();
		            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-M-dd");
		            LocalDate date2 = LocalDate.parse(date1, dtf2);
		            theDvD.setReleaseDate(date2);
				}
				else if (input.equals("director")) {
					System.out.println("Enter new DvD Director : ");
					theDvD.setDirector(scanner.nextLine());;
				}
				else if (input.equals("rating")) {
					System.out.println("Enter new DvD Rating : ");
					theDvD.setRating(scanner.nextLine());;
				}
				else if (input.equals("studio")) {
					System.out.println("Enter new DvD Studio : ");
					theDvD.setStudio(scanner.nextLine());;
				}
				else if (input.equals("duration")) {
					System.out.println("Enter new DvD Duration : ");
					theDvD.setDuration(scanner.nextDouble());;
				}
				dvdService.updateDvD(theDvD);
				
			}
			else {
				System.out.println("DvD with id "+dvdId+" does not exist");
			}
			break;
		
		case 6:
			System.out.println("Thanks for using Book Management System");
			// void method for exiting program, it terminates the currently running JVM and exits the program
			// the parameter integer 0 - means normal exit, any non-zero integer is considered an abnormal exit
			// this method stops any subsequent lines from running
			// it is used when we want to exit the program from somewhere other than the main class of the program
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}
		
	}

}
