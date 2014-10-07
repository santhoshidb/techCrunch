
package cocoListings.client;

import com.smartgwt.client.types.Alignment;  
import com.smartgwt.client.types.AnimationAcceleration;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;  
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;  
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;  
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;  
import com.google.gwt.core.client.EntryPoint;  
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
		  
		public class CocoListings implements EntryPoint {  
			
			/*DEMO NOTE: /images/dbporsche1-6.jpgs are being used for details on classified for db porsche
			 * and count keeps track of the photo being displayed*/
			private int count = 1;
			public int toggle =1; 
			
			final VLayout layout = new VLayout(); 
			public Label tag1 = new Label();
			public Label tag2 = new Label();
			public Label tag3 = new Label();
			public Label tag4 = new Label();
			
		    //parameters for images extremeleft = l, extremeright=r and incenter = c
			//image height and width = ih and iw
	      //  int ih=680, iw=1024,cl=30,ct=80;
	        //.7 for projector
	        int ih=476, iw=717,cl=30,ct=80;
	        
		 	final Img t1 = new Img("/images/dbporsche"+1+".jpg");
			final Img t2 = new Img("/images/dbporsche"+2+".jpg");
			final Img t3 = new Img("/images/dbporsche"+3+".jpg");
			final Img t4 = new Img("/images/dbporsche"+4+".jpg");
			final Img t5 = new Img("/images/dbporsche"+5+".jpg");
			final Img t6 = new Img("/images/dbporsche"+6+".jpg");
			  
		    public void onModuleLoad() {  	  
		       
				layout.setAnimateAcceleration( AnimationAcceleration.SMOOTH_START_END);
		    	//Demo: Thumbnails
				//thumbnail dimensions tl,tt,tw,th
				//  int tl = 130,tt = 770,tw = 128,th = 85;
				//int tl = 130,tt = 770,tw = 128,th = 85;
				//.7 for projector
				int tl = 91,tt = 570,tw = 90,th = 60;
				  t1.setParentElement(layout);
				  t1.setRect(tl,tt,tw,th); //border the first thumbnail
				  t1.setBorder("3px solid blue");
				  
				  t2.setParentElement(layout);
				  t2.setRect(tl+tw+10,tt,tw,th);
				  
				  t3.setParentElement(layout);				  
				  t3.setRect(tl+2*(tw+10),tt,tw,th);
				  
				  t4.setParentElement(layout);				 
				  t4.setRect(tl+3*(tw+10),tt,tw,th);
				  
				  t5.setParentElement(layout);				 
				  t5.setRect(tl+4*(tw+10),tt,tw,th);
				  
				  t6.setParentElement(layout);				  
				  t6.setRect(tl+5*(tw+10),tt,tw,th);
				  
		        final Img class1 = new Img("/images/dbporsche"+count+".jpg");
		        //Show first image
		        final Img class2 = new Img("/images/dbporsche"+(count+1)+".jpg");
		        Window.enableScrolling(false);
		        class1.setParentElement(layout);  
		        class2.setParentElement(layout);
		        //class1.setStyleName("centerImage");
		        //class2.setStyleName("centerImage");
		        class1.setShowShadow(true);
		        class2.setShowShadow(true);
		        //class1.setShowEdges(true);
		        //class2.setShowEdges(true);
		        class1.setPadding(5); 
		        class2.setPadding(5);
		        //class1.setRect(50, 60, 912, 605);
		        class1.setRect(cl,ct,iw,ih);
		        class1.setValign(VerticalAlignment.CENTER);  
		        class1.setAlign(Alignment.CENTER);
		        class2.setValign(VerticalAlignment.CENTER);  
		        class2.setAlign(Alignment.CENTER);  
		        
		       // class1.setAnimateTime(3000);// milliseconds  
		       // class2.setAnimateTime(3000);// milliseconds  		 
		        final IButton moveInButton = new IButton();  
		        moveInButton.setTitle("");  
		        moveInButton.setRect(0, 0, 1, 1)  ;
		        moveInButton.addDrawHandler(new DrawHandler(){
					@Override
					public void onDraw(DrawEvent event) {
					//	Window.alert("button focussed");
						moveInButton.focus();
					}		        	
		        });
		      
		        moveInButton.addKeyPressHandler(new KeyPressHandler(){

					@Override
					public void onKeyPress(KeyPressEvent event) {
						// TODO Auto-generated method stub
						
						//rIGHT KEY moves forward
						if (event.getKeyName().equals("Arrow_Right")){
							switch(toggle){
						case 1: 
							//move current image out
				
							class1.animateMove(20000, ct ); 
							//move new image in
							moveThumbsR();
							count++;
							if(count>6) count=1;
							class2.setRect(-3000, ct, iw, ih);
							class2.setSrc("/images/dbporsche"+count+".jpg");
							
							class2.animateMove(cl, ct);
							toggle=2;
							break;
						case 2:
							//move current image out
							class2.animateMove(20000, ct); 
							//move new image in
							moveThumbsR();
							count++;
							if(count>6) count=1;
							class1.setRect(-3000, ct, iw, ih);
							class1.setSrc("/images/dbporsche"+count+".jpg");
							
							class1.animateMove(cl, ct);
							toggle=1;
							break;
						default: break;
					}}
							
						//lEFT KEY moves backward
						if (event.getKeyName().equals("Arrow_Left")){
							//move current image out
								switch(toggle){
							case 1: 
								//move current image out
								class1.animateMove(-20000, ct ); 
								//move new image in
								moveThumbsL();
								count--;
								if(count<1) count=6;
								class2.setRect(3000, ct, iw, ih);
								class2.setSrc("/images/dbporsche"+count+".jpg");
								class2.animateMove(cl, ct);
								toggle=2;
								break;
							case 2:
								//move current image out
								class2.animateMove(-20000, ct); 
								//move new image in
								moveThumbsL();
								count--;
								if(count<1) count=6;
								class1.setRect(3000, ct, iw, ih);
								class1.setSrc("/images/dbporsche"+count+".jpg");
								class1.animateMove(cl, ct);
								toggle=1;
								break;
							default: break;
						}}
						
						//ESCAPE adds tags
						if (event.getKeyName().equals("Escape")){
						//	Window.alert("escape");
							createTags();
							
						}
						//End removes tags
						if (event.getKeyName().equals("End")){
						//	Window.alert("end");
							deleteTags();
						}
					}
		        });
		        
		        //Add layout for heading and listing details
		       /*	Label label = new Label();
		        label.setShowEdges(false);  
		        label.setStyleName("sendButton");
		        label.setSize("1168px", "50px");
		        label.setTop(0);
		        label.setAlign(Alignment.CENTER);
		        label.setContents("Coco Listings<BR></u>Classifieds</u> -> For Sale -> Cars: David Beckham's 2008 Porsche 911 Turbo Cabriolet");
		        layout.addMember(label);*/
		        /** 
		        //headers
		        HLayout hl = new HLayout();
		        VLayout header1 = new VLayout();
		        VLayout header2 = new VLayout();
		        VLayout header3 = new VLayout();
		        VLayout header4 = new VLayout();
		        VLayout header5 = new VLayout();
		        
		        int hh = 70, hw = 180;
		        //header1.setShowEdges(true);
		        //header1.setBorder("1px solid black");
		        header1.setSize(hw+"px", hh+"px");
		        //header1.setAlign(Alignment.CENTER);
		        header1.addMember(new Img("/images/cocolist-logo-small.gif"));
		        //header1.setIconHeight(70);
		        //header1.setIconWidth(180);
		        //header1.setIcon("/images/cocolist-logo-small.gif");
		       
		        hl.addMember(header1);
		        
		        //header2.setShowEdges(true);
		        //header2.setBorder("1px solid black");
		        header2.setContents("VIN: xxxxxxxxxxxxxxx <BR>Engine:<BR>Transmission:");
		        //header2.setSize("270px",hh+"px");
		        //header2.setAlign(Alignment.LEFT);
		        hl.addMember(header2);
		        
		        //header3.setShowEdges(true);
		        //header3.setBorder("1px solid black");
		        header3.setContents("Interior Color:NATURAL BROWN <BR>Interior Surface:Leather<BR>Exterior Color:White");
		        //header3.setSize("272px",hh+"px");
		        //header3.setAlign(Alignment.LEFT);
		        hl.addMember(header3);
		        
		        //header4.setShowEdges(true);
		        //header4.setBorder("1px solid black");
		        header4.setContents("Warranty:Factory <BR>Miles:26,000<BR>CARFAX:");
		        //header4.setSize("270px",hh+"px");
		        //header4.setAlign(Alignment.LEFT);
		        hl.addMember(header4);
		        
		        //header5.setShowEdges(true);
		        //header5.setBorder("1px solid black");
		        header5.setContents("2007 Porsche 911 Carrera <BR>Cabriolet White<BR>$57,000");
		        //header5.setSize("175",hh+"px");
		        //header5.setAlign(Alignment.LEFT);
		        hl.addMember(header5);
		        
		        layout.addMember(hl);
		        **/
		        
		        layout.addMember(moveInButton);
		       
		        layout.draw();  
	        
		    }
		  
		 
		private void createTags(){
			  //Demo: Create tags for image 3
				tag1.setBorder("2px solid black");
		        tag1.setSize("20px", "20px");
		        tag1.setPageLeft(-1500);
		        tag1.setAlign(Alignment.CENTER);
		        tag1.setContents("  ");
		        tag1.setOpacity(100);
		        tag1.setPrompt("Original Porsche Xenon lights");		    
		      	tag1.setHoverWrap(true);
		      	tag1.setHoverWidth(128);
		      	
		      	tag2.setSize("20px", "20px");
		        tag2.setBorder("2px solid black");
		        tag2.setPageLeft(-1500);
		        tag2.setAlign(Alignment.CENTER);
		        tag2.setOpacity(100);  	
		      	tag2.setPrompt("New tires.<br>Installed 200 miles ago");
		      	tag2.setHoverWrap(true);
		      	tag2.setHoverWidth(128);
		      	
		      	tag3.setSize("20px", "20px");
		        tag3.setBorder("2px solid black");
		        tag3.setPageLeft(-1500);
		        tag3.setAlign(Alignment.CENTER);		   
		        tag3.setOpacity(100);
		      	tag3.setPrompt("Porsche crest on the headrests");
		      	tag3.setHoverWrap(true);
		      	tag3.setHoverWidth(128);

		      	tag4.setSize("20px", "20px");
		        tag4.setBorder("2px solid black");
		        tag4.setPageLeft(-1500);
		        tag4.setAlign(Alignment.CENTER);
		        tag4.setOpacity(100);
		      	tag4.setPrompt("Original GT3 spoiler");
		      	tag4.setHoverWrap(true);
		      	tag4.setHoverWidth(128);
		      	
		       	layout.addMember(tag1);
		        layout.addMember(tag2);
		        layout.addMember(tag3);
		        layout.addMember(tag4);
		        
		        //Demo: move tags to image
		        int tagl,tagt;
		        /*tag1.animateMove(150, 525);
		        tag2.animateMove(700, 650);
		        tag3.animateMove(550, 425);
		        tag4.animateMove(925,450);*/
		        //.7 for projector
		        tag1.animateMove(105, 372);
		        tag2.animateMove(485, 455);
		        tag3.animateMove(375, 298);
		        tag4.animateMove(648,330);
		        
		      	
		  }

		  private void deleteTags() {
				// TODO Auto-generated method stub
			 tag1.setVisible(false);
			  tag2.setVisible(false);
			  tag3.setVisible(false);
			  tag4.setVisible(false);
				tag1.removeFromParent();
				tag2.removeFromParent();
				tag3.removeFromParent();
				tag4.removeFromParent();
			}
	        
		  private void moveThumbsR(){
			  switch (count){
			  case 1: 
				  t1.setBorder("0px solid blue");
				  t2.setBorder("3px solid blue");
				  break;
			  case 2: 
				  t2.setBorder("0px solid blue");
				  t3.setBorder("3px solid blue");
				  break;
			  case 3: 
				  t3.setBorder("0px solid blue");
				  t4.setBorder("3px solid blue");
				  break;
			  case 4: 
				  t4.setBorder("0px solid blue");
				  t5.setBorder("3px solid blue");
				  break;
			  case 5: 
				  t5.setBorder("0px solid blue");
				  t6.setBorder("3px solid blue");
				  break;
			  case 6: 
				  t6.setBorder("0px solid blue");
				  t1.setBorder("3px solid blue");
				  break;
			  }
		  }
		  
		  private void moveThumbsL(){
			  switch (count){
			  case 1: 
				  t1.setBorder("0px solid blue");
				  t6.setBorder("3px solid blue");
				  break;
			  case 2: 
				  t2.setBorder("0px solid blue");
				  t1.setBorder("3px solid blue");
				  break;
			  case 3: 
				  t3.setBorder("0px solid blue");
				  t2.setBorder("3px solid blue");
				  break;
			  case 4: 
				  t4.setBorder("0px solid blue");
				  t3.setBorder("3px solid blue");
				  break;
			  case 5: 
				  t5.setBorder("0px solid blue");
				  t4.setBorder("3px solid blue");
				  break;
			  case 6: 
				  t6.setBorder("0px solid blue");
				  t5.setBorder("3px solid blue");
				  break;
			  }
		  }
		
		}  