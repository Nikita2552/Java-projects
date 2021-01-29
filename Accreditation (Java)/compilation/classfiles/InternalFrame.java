import javax.swing.*;
import java.util.*;
import java.io.*;
import java.time.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//String way = C:/InternalFrame_release_2020/Videos/textfile_java.txt;

public class InternalFrame extends JFrame {
	
	JDesktopPane desktopPane = new JDesktopPane();

	//**
	videoFrame intVideo = new videoFrame();
	timeFrame intTime = new timeFrame();
	ethernetFrame intEthernet = new ethernetFrame();
	registratorFrame intRegistrator = new registratorFrame();
	
	JMenuItem time1 = new JMenuItem( "Time" );
	JMenuItem video1 = new JMenuItem( "Video" );
	JMenuItem ethernet1 = new JMenuItem( "Ethernet" );
	JMenuItem registrator1 = new JMenuItem( "Registrator" );
	
	JMenuBar bar = new JMenuBar();
    //
	
	//Флаг того, что данное новое: true - новое
    private boolean newData;
    
    public String Data;
	
	public InternalFrame() {
		//**
		/* Настройка окна Video */ 
		intVideo.setMaximizable(true);
		intVideo.setIconifiable(true);
		intVideo.setResizable(true);
		intVideo.setClosable(true);
		intVideo.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		intVideo.setSize(700,200);
		//intSound.setVisible(true);
		
		desktopPane.add(intVideo);
		//add(desktopPane);
		
		/* Настройка окна Time */
		intTime.setMaximizable(true);
		intTime.setIconifiable(true);
		intTime.setResizable(true);
		intTime.setClosable(true);
		intTime.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		intTime.setSize(400,300);
		//intTime.setVisible(true);
		
		desktopPane.add(intTime);
		//add(desktopPane);
		
		/* Настройка окна Ethernet */
		intEthernet.setMaximizable(true);
		intEthernet.setIconifiable(true);
		intEthernet.setResizable(true);
		intEthernet.setClosable(true);
		intEthernet.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		intEthernet.setSize(400,300);
		//intEthernet.setVisible(true);
		
		desktopPane.add(intEthernet);
		
		/* Настройка окна Registrator */ 
		intRegistrator.setMaximizable(true);
		intRegistrator.setIconifiable(true);
		intRegistrator.setResizable(true);
		intRegistrator.setClosable(true);
		intRegistrator.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		intRegistrator.setSize(400,300);
		//intSound.setVisible(true);
		
		desktopPane.add(intRegistrator);
		//add(desktopPane);
		
		add(desktopPane);
		
		//
		
		//**
	      
	      bar.add( time1 );
	      bar.add( video1 );
	      bar.add( ethernet1 );
	      bar.add( registrator1 );
	      
	      //

          /* Событие "Нажатие кнопки time1" */
	      time1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	
	        	  System.out.println("time1");
	        	  
	        	  intTime.setVisible(true);
	          }
	      });
	      
	      /* Событие "Нажатие кнопки video1" */
	      video1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  System.out.println("video1");
     	  
	        	  intVideo.setVisible(true);
	        	  
	          }
	      });
	      
	      /* Событие "Нажатие кнопки ethernet1" */
	      ethernet1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  
	        	  System.out.println("ethernet1");
	        	  
	        	  intEthernet.setVisible(true);
	        	  
	          }
	      });
	      
	      /* Событие "Нажатие кнопки registrator1" */
	      registrator1.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	
	        	  System.out.println("registrator1");
	        	  
	        	  intRegistrator.setVisible(true);
	          }
	      });
	      
	      setJMenuBar( bar );
		
	}
	
	public static void main(String[] args) {
		InternalFrame iFrame = new InternalFrame();
		iFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		iFrame.setSize(640,480);
		iFrame.setVisible(true);
        
	}
	
	public class timeFrame extends JInternalFrame
	{
	    
		int interval;
	    Timer timer;
	    //Сумма секунд всех интервалов
		int summ;
		//Размер массива 
		int countlist;
		//Текущий интервал
		int numberlist;
		//Флаг последнего сообщения    
		boolean flag;
		boolean flag1;
		boolean flag2;
		
		String strA;
		String strB;
		int intA;
		int intB;
		
		// Модель списка
	    private DefaultListModel<String> dlm = new DefaultListModel<String>();
	    private DefaultListModel<String> dlm1 = new DefaultListModel<String>();
	    private LinkedList <String> data1 = new LinkedList<> ();// { "5" ,"8"  ,"7","6"};
	    private LinkedList <String> data3 = new LinkedList<> ();// { "5" ,"8"  ,"7","6"};
	    int data2[];
	    
	    JLabel label2 = new JLabel ("");
	    JLabel label3 = new JLabel ("time:");
		
	    public timeFrame()
	    {
	        super("Time");
	        
	        data1.add(0, "5"); data1.add(1, "8"); data1.add(2, "7"); data1.add(3, "6");
	        
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        // Создание панели c возможностью позиционирования
	        JPanel contents = new JPanel();
	        contents.setLayout(null);
	        
	        for (int i = 0; i < data1.size(); i++) {
	                  dlm.add(i, data1.get(i));
	        }
	        
	        JList<String> list1 = new JList<String>(dlm);
	        JScrollPane Scr = new JScrollPane(list1); 
	        Scr.setBounds(1, 80, 180, 100);
	        contents.add(Scr);
	        
	        JList<String> list2 = new JList<String>(dlm1);
	        JScrollPane Scr1 = new JScrollPane(list2); 
	        Scr1.setBounds(380, 80, 180, 100);
	        contents.add(Scr1);
	        
	        //Создание кнопки
	        JButton add1 = new JButton("Добавить в список");
	        // 1 - x, 2 - y, 3 - width, 4 - height
	        add1.setBounds(1, 1, 180, 30);
	        contents.add(add1);
	       //Создание кнопки
	        JButton add2 = new JButton("Удалить из списка");
	        add2.setBounds(1, 40, 180, 30);
	        contents.add(add2);
	        contents.add(add1);
	        //Создание кнопки
	         JButton add5 = new JButton("Добавить в аудио");
	         add5.setBounds(380, 1, 180, 30);
	         contents.add(add5);
	        
	         //Создание кнопки
	        JButton add3 = new JButton("Начать проход");
	        add3.setBounds(1, 190, 190, 30);
	        contents.add(add3);
	      //Создание кнопки
	        JButton add4 = new JButton("Прекратить проход");
	        add4.setBounds(195, 190, 190, 30);
	        contents.add(add4);
	        
	        //Создание поля  
	        JTextField bigField1 = new JTextField("Введите количество секунд", 25);
	        bigField1.setBounds(190, 1, 180, 30);
	        contents.add(bigField1);
	      //Создание поля 
	        JTextField bigField2 = new JTextField("Введите номер интервала", 25);
	        bigField2.setBounds(190, 40, 180, 30);
	        contents.add(bigField2);
	      //Создание поля  
	        JTextField bigField3 = new JTextField("Введите расположение папки с сообщениями", 25);
	        bigField3.setBounds(570, 1, 180, 30);
	        contents.add(bigField3);
	      //Добавление меток
	        JLabel label1 = new JLabel ("Здесь будет статус:");
	        label1.setBounds(190, 40, 180, 100);
	        contents.add(label1);
	      //Размещение выводящих меток
	        label3.setBounds(190, 60, 180, 100);
	        contents.add(label3);
	      //Размещение выводящих меток
	        label2.setBounds(190, 80, 180, 100);
	        contents.add(label2);
	        
	      /////////
	        
            add1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           //dlm.add(dlm.getSize(), "-- Новая запись --");
           //validate();
       	
       	boolean flag1, flag2;
       	
       	try {
       		strA = bigField1.getText(); 
       		intA = Integer.parseInt(strA); //читаем с текстового поля текст, преобразуем в Double
       		//a += 2; //тут я прибавляю a = a + 2
           	//jTextField1.setText(a.toString()); //вывожу обратно результат в текстовое поле
       		flag1 = true; 
       	} catch(NumberFormatException intA) {
       		strA = "NumberFormatException strA";
       		flag1 = false;
               //return false; 
           } catch(NullPointerException intA) {
               //return false;
           	strA = "NullPointerException strA";
           	flag1 = false;
           }
       	
       	try {
       		strB = bigField2.getText(); 
       		intB = Integer.parseInt(strB); //читаем с текстового поля текст, преобразуем в Double
       		//a += 2; //тут я прибавляю a = a + 2
           	//jTextField1.setText(a.toString()); //вывожу обратно результат в текстовое поле
       		flag2 = true; 
       	} catch(NumberFormatException intB) {
       		strB = "NumberFormatException strB";
       		flag2 = false;
               //return false; 
           } catch(NullPointerException intB) {
               //return false;
           	strB = "NullPointerException strB";
           	flag2 = false;
           }
       	
//Если оба поля введены верно, то дополняем список        	
       	if ((flag1 == true) && (flag2 == true)) {
       		
       		LinkedList <String> dlm_clone = new LinkedList<> (); //System.out.println(dlm.size());

       		for (int i = intB; i < dlm.size(); i++)
       		{
       			dlm_clone.add(dlm.get(i)); //Создание копии смещаемой части массива
       			System.out.println("dlm["+i + "]="+dlm.get(i));
       		}
       		
       		for (int i = dlm.size() - 1; i >= intB; i--)
       		{
       		    dlm.remove(i); //Удаление скопированных элементов
       		}
       		
        		dlm.add(dlm.size(), strA); //Добавляем нужный элемент
        		
       		int sizeB = dlm.size() - 1;
        		
       		for (int i = 0; i < dlm_clone.size(); i++)
       		{
       			dlm.add(1 + sizeB, dlm_clone.get(i)); //Добавление остальных элементов
       		}
       		
        		for (int i = 0; i < dlm.size(); i++)
       		{
       		    System.out.println(dlm.get(i)); 
       		}
 
       	}
       
       	System.out.println("Добавлен!");
       }
   });
   
   add2.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
                   	
       	try {
       		strB = bigField2.getText(); 
       		intB = Integer.parseInt(strB); //читаем с текстового поля текст, преобразуем в Double
        	} catch(NumberFormatException intB) {
       		strB = "NumberFormatException strB";
            } catch(NullPointerException intB) {
               strB = "NullPointerException strB";
            }
       	
       	if (dlm.size() > intB)
       	{
       	dlm.remove(intB); //Удаление скопированных элементов
       	}
       	
       	System.out.println("Удалён!"); 
       }
   }); 
   //Начать проход
            add3.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
       	Scanner sc = new Scanner(System.in);
           System.out.print("Input seconds => : ");
                             
           //String secs = "10"; //sc.nextLine();
           int delay = 1000;
           int period = 1000;
           timer = new Timer();
                       
           countlist = list1.getModel().getSize();
           Object item;
           data2 = new int[countlist];
           summ = 0;
           
           for (int i = 0; i < countlist; i++) {
           	//Получили объект строчки полосы прокрутки
               item = list1.getModel().getElementAt(i);
               //Преобразовали объект строки в строку
               String item1 = item.toString();
               //Преобразовали строчку в число
               data2[i] = Integer.parseInt(item1);
               summ += data2[i];
               System.out.println("Item = " + data2[i]);
               if (i == 0) { //(countlist - 1)) {
               	numberlist = data2[0];
               	System.out.println("numberlist = " + numberlist);
               }
           }
           System.out.println("summ = " + summ);
           countlist = 0;
           interval = summ;
           System.out.print("Input seconds => : ");
           System.out.println(interval);
           flag = true; 
           timer.scheduleAtFixedRate(new TimerTask() {

               public void run() {
               	//int tm = setInterval();
               	//String time = toString(tm);
               	label3.setText("time: "+ setInterval() ); //int k = setInterval();
               	//System.out.println(setInterval()); System.out.println("!");

               }
           }, delay, period);
      
       }
   });
 
   add4.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           interval = 1;
           flag = false;
       }
   });

       
       setContentPane(contents);
       	        
	    ////////
	    }
	    
	    ////////
	    
	    private int setInterval() {
	    	
	    	if (interval == 1) {
	    		if (flag == true)	{	
	    			label2.setText("Сообщение N" + countlist); System.out.println("Сообщение N" + countlist);
	    			ethernetSignal("Сообщение N" + countlist, true);
	    		}
	    	timer.cancel();
	    }
	    	if (interval == (summ - numberlist)) {
	    		label2.setText("Сообщение N" + countlist); System.out.println("Сообщение N" + countlist);
	    		ethernetSignal("Сообщение N" + countlist, true);
	    		summ -= numberlist;
	    		++countlist; System.out.println(countlist);
	    		numberlist = data2[countlist];
	    }
	    
	    return --interval;
	    }
	    
	    private void ethernetSignal(String str, boolean flag) {
	    
	    	Data = str; //Отсылаем данное окну в роли клиента
	    	newData = flag; //Устанавливаем флаг новизны данных
	    }
	    
	    ///////
	    
	}
		
	public class videoFrame extends JInternalFrame
	{
	    
		// Для примера: данные для таблиц
	    private Object[][] array = new String[][] {{ "KastaMetla.mp4" , "D:/OOP/Videos/KastaMetla.mp4", "Совпадение найдено (пример)" }};
	    private Object[] arraystr = new String[] {"00:01:05", "0:0:55", "D:/OOP/Videos/KastaMetla.mp4", "D:/OOP/Videos/Narezka/KastaMetla/Kasta1-1.mp4"};
	    
	    private Vector <String>  fileStrings  = new Vector<String>();
	    private Vector <Vector <String>>  pathStrings  = new Vector<Vector <String>>();
	    private Vector <Vector <String>>  fileEndStrings;
	    private Vector <Vector <String>>  pathEndStrings;
	    private Vector <Vector <String>>  convertStrings;
	    private Vector <String>  convertFolders;
	    private Vector <String>  pathStr;
	    private String videoFolder;
	    private String cutFolder;
	    
	    // Заголовки столбцов
	    private Object[] columnsHeader = new String[] {"Название файла", "Адрес файла", "Статус"}; //, "Массив фрагментов"};
		
	  /// Простая таблица
	    JTable table1;
	 // Модель данных таблицы
	    private DefaultTableModel tableModel;
		
	    public videoFrame() {
	        super("Video");//, true, true, true, true );

	    	// Создание стандартной модели
	        tableModel = new DefaultTableModel();
	        // Определение столбцов
	        tableModel.setColumnIdentifiers(columnsHeader);
	        // Наполнение модели данными для примера
	        for (int i = 0; i < array.length; i++)
	            tableModel.addRow(array[i]);
	        
	      /// Простая таблица
	        table1 = new JTable(tableModel);
	        Box contents = new Box(BoxLayout.Y_AXIS);
	        contents.add(new JScrollPane(table1));
	    	
	        // Создание панели c возможностью позиционирования
	        JPanel pnlButtons = new JPanel();
	         
	      //Создание поля  
	        JTextField bigField1 = new JTextField("Введите ссылку на файл с названиями и временем", 30);
	        //bigField1.setBounds(130, 50, 180, 30);
	        pnlButtons.add(bigField1);
	        
	     // Кнопка добавления колонки в модель VideoTest
	        JButton table = new JButton("Внести в таблицу");
	        pnlButtons.add(table);
	        
	     // Кнопка добавления колонки в модель VideoTest
	        JButton obr = new JButton("Обрезать файл");
	        pnlButtons.add(obr);
	          
	     // Слушатель обработки события
	        obr.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            	System.out.println("Нажатие кнопки - Обрезать файл");
	            	
	            	System.out.println("pathEndStrings = " + pathEndStrings);
	            	System.out.println("fileEndStrings = " + fileEndStrings);
	            	
	            	//1. Конвертировать запись первого файла из списка в параметры для ffmpeg.exe
	            	
	            	convertOffile();  System.out.println("convertStrings = " + convertStrings); System.out.println("convertFolders = " + convertFolders);
	            	
	            	//2. Создать папку Narezka_java и вложенные папки для нарезаемых файлов
	            	
	            	folderOffile();
	            	
	            	//3. Запустить ffmpeg.exe при помощи процессов и передать параметры
	            	
	            	processOffile();
	            	
	            	//4. Ждать, пока не завершится нарезка файла и прислать подтверждение, статус "Нарезка завершена"
	            	
	            	endOffile();
	            	
	            }
	        });
	        
	     // Слушатель обработки события
	        table.addActionListener(new ActionListener() {
	             public void actionPerformed(ActionEvent e) {

	            	 System.out.println("Нажатие кнопки - внести в таблицу");
	            	 
	            	 //1. Прочитать построчно из файла
	            	 
	            	 //Для примера
	            	 //String way = "D:\\OOP\\Videos\\textfile_java.txt";
	            	 String way = bigField1.getText();
	             	 readOffile(way);
	            	 
	            	 //2. Выделить в файле путь к папке
	            	 
	            	 videoFolder = fileStrings.get(0); System.out.println(videoFolder);
	            	 cutFolder = fileStrings.get(1); System.out.println(cutFolder);

	            	 //3. Осуществить поиск в этой папке и найти все файлы .mp4
	            	 
	            	 searchOffile(videoFolder);
	            	 
	            	 //4. Сравнить файлы из списка и найденные файлы.
	            	 
	            	 compareOffile();
	            	 
	            	 //5. Совпавшие файлы и их пути внести в таблицу
	            	 
	            	 addOffile();
	            }
	        });
	        
	        getContentPane().add(contents);
	        getContentPane().add(pnlButtons, BorderLayout.NORTH);
	        // Вывод окна
	        //setSize(700, 200);
	        //setVisible(true);
	    }
	/////////    

	    private void readOffile(String way) {
	    	
			fileStrings = new Vector<String>();
			
			try {
	            File file = new File(way);
	            //создаем объект FileReader для объекта File
	            FileReader fr = new FileReader(file);
	            //создаем BufferedReader с существующего FileReader для построчного считывания
	            BufferedReader reader = new BufferedReader(fr);
	            // считаем сначала первую строку
	            String line = reader.readLine();
	            while (line != null) {
	                System.out.println(line);
	               //Добавление в массив строк:
	                fileStrings.add(line);
	               // считываем остальные строки в цикле
	                line = reader.readLine();
	            }
	        } catch (FileNotFoundException a) {
	            a.printStackTrace();
	        } catch (IOException b) {
	            b.printStackTrace();
	        }
		}
		
		private void searchOffile(String way) {
		
			File folder = new File(way);
			
			pathStrings = new Vector<Vector <String>>();
			
			processFilesFromFolder(folder);
		}
		
		private void processFilesFromFolder(File folder) {
				
			File[] folderEntries = folder.listFiles();
		    String fileName;
		    String filePath;
		    boolean end;
		    
		    for (File entry : folderEntries)
		    {
		        if (entry.isDirectory())
		        {
		            processFilesFromFolder(entry);
		            continue;
		        } else {
			        // иначе вам попался файл, обрабатывайте его!
		        	fileName = entry.getName();
		        	//Проверка, соответствует ли формат файла
		        	end = fileName.endsWith(".mp4");
		        	if (end == true)
		        	{
		        		 filePath = entry.getAbsolutePath(); System.out.println(fileName + " " + filePath);
		        		 
		        		 pathStr = new Vector<String>();
	   		 
		        		 //Добавление имён файлов и путей в выходной массив
		        		 pathStr.add(fileName);
		        		 pathStr.add(filePath);
		        		 //Не добавляется. Понять почему. Понять, почему глючит!!!
		        		 pathStrings.add(pathStr); System.out.println("!! pathStr " + pathStr);
		        	}
		        }
		    }
		}
		
		private void compareOffile() {
			
			pathEndStrings = new Vector<Vector <String>>();
			fileEndStrings = new Vector<Vector <String>>();
			
			int iSize = pathStrings.size(); System.out.println("path iSize = " + iSize);
			Vector<String> fileName = new Vector<String>();
			Vector<String> searchVector = new Vector<String>();
			String nameStr;
			
			System.out.println("!! pathStrings " + pathStrings);
			
			for (int i = 0; i < iSize; i++) {
				fileName = pathStrings.get(i);
				nameStr = fileName.get(0);
				//Поиск совпадения с массивом из списка
				searchVector = searchOfarray(nameStr); System.out.println("compareOffile for- i = " + i + " nameStr = " + nameStr); System.out.println("for- searchVector = " + searchVector );

				int sSize = searchVector.size(); System.out.println("path sSize = " + sSize);
				if (sSize > 0) {
					System.out.println("searchVector is not null!");
					//В этом случае мы нашли некое количество подходящих записей
					fileName.add("Совпадение найдено");
					//Добавляем в конечный массив имен/путей
					searchVector.add(0, nameStr);
					fileEndStrings.add(searchVector);
					
				} else {
					System.out.println("searchVector is null!");
					//В этом случаемы ничего не нашли. Файла, как в списке, в дирректории не существует.
					fileName.add("Совпадение не найдено");
				}
				
				//Добавляем в конечный массив имен/путей для таблицы
				pathEndStrings.add(fileName);
			}
			
		}
		
		private Vector<String>searchOfarray(String str) {
			
			Vector<String> searchVector = new Vector<String>(); 
			int index = fileStrings.indexOf(str); System.out.println("searchOfarray index = " + index);
			int i = index + 1;
			int iSize = fileStrings.size(); System.out.println("searchOfarray iSize = " + iSize);
			String endStr;
			boolean end;
			//Если проверка по индексу что то нашла, то 
			if (index > 0) {
			
				while(i < iSize) {
					endStr = fileStrings.get(i);
					//Проверка, соответствует ли формат файла
		        	end = endStr.endsWith(".mp4");
		        	if (end == false)
		        	{
		        		searchVector.add(endStr);
		        		i++;
		        	} else {
		        		i = iSize;
		        	}
				}
				
			}
			
			return searchVector;
		}
		
		//Добавление данных в таблицу
		private void addOffile() {
			
			//Для примера
	   	 	//String way = "D:\\OOP\\Videos\\textfile_java.txt";
			tableModel.setRowCount(1);

			Vector <String> pathStr = new Vector<String>();
			int iSize = pathEndStrings.size();
			
			for (int i = 0; i < iSize; i++) {
				pathStr = pathEndStrings.get(i);
				tableModel.addRow(pathStr);
			}
		}

		private void convertOffile() {
			
			convertStrings  = new Vector<Vector <String>>();
			convertFolders  = new Vector <String>();
		
			Vector <String> str = fileEndStrings.get(0);
			int strSize = str.size();
			String[] substr;
			String curstr;
			
			//0. Добавление пути в первую папку в начале массива
			arrayOffolders(cutFolder);
			
			for (int i = 1; i < strSize; i++) {
				curstr = str.get(i);
				substr = curstr.split(" "); System.out.println("substr = [" + substr[0] + "], [" + substr[1] + "], [" + substr[2] + "]");
				
				//1. Конвертировать время начала и время конца отрезка во время начала и длину отрезка, который нужно вырезать.
				
				int subSize = substr.length; //Получаем длину элементов массива
				int startsubstr;
				int finishsubstr;
				String convsubstr;
				String fileName;
				String menuName;
				String childPath;
				String folderPath;
				Vector <String> parameters;
				
				startsubstr = timeOfsubstr(substr[1]); System.out.println("startsubstr = " + startsubstr);
				finishsubstr = timeOfsubstr(substr[2]); System.out.println("finishsubstr = " + finishsubstr);
				
				convsubstr = differnceOfsubstr(startsubstr, finishsubstr);
			
				//2. Найти путь к исходному файлу в массиве.
				
				fileName = str.get(0);
				menuName = searchOfmenu(fileName); System.out.println("menuName = " + menuName);
				
				//3. Создать путь к нарезанному файлу из переменной, папки Narezka и имени файла.
				// Cutfolder + fileName - ".mp4" + "\\" + substr[0]
				
				childPath = formOfpath(fileName, substr[0]); System.out.println("childPath = " + childPath);
				
				//4. Создать массив из строчек с параметрами из первого файла.
				//строки с параметрами: menuName, childPath, substr[1], convsubstr
				
				parameters = parametersOfstr(menuName, childPath, substr[1], convsubstr); System.out.println("parameters = " + parameters);
				convertStrings.add(parameters);
				
				//5. Создать массив из строк с путёми для папок, которые тебуется создать
				// Cutfolder + fileName - ".mp4" + "\\"
				
				folderPath = foldOfPath(fileName); System.out.println("folderPath = " + folderPath);
				
				//6. Создать массив строчек  с параметрами для создания папок нарезки
				
				arrayOffolders(folderPath); 			
			}
		}
		
		private void folderOffile() {
		
			int cSize = convertFolders.size();
			
			for (int i = 0; i < cSize; i++) {
				createOffolder (convertFolders.get(i));
			}
			
		}
		
		private void createOffolder (String addr) {
			// create an abstract pathname (File object) 
	        File f = new File(addr); 
	  
	        // Проверка, может ли директория быть создана
	        if (f.mkdir()) { 
	             System.out.println("Директория создана"); 
	        } else { 
	            System.out.println("Директория не создана"); 
	        } 
		}
			
		private void processOffile() {
			//Для примера
	   	 	//String way = "D:\\OOP\\Videos\\textfile_java.txt";
	     	createOfprocess("C:/InternalFrame_release_2020/ffmpeg/bin/ffmpeg.exe", convertStrings.get(0));
		}
		
		private void createOfprocess(String program, Vector<String>parameters) {
			
			try {
				//arguments << "-ss" << "00:01:00" << "-t" << "00:01:00" << "-i" << "D:/OOP/Videos/KastaMetla.mp4" << "D:/OOP/Videos/Kasta1-1.mp4";
				System.out.println(program + " -ss " + parameters.get(2) + " -t " + parameters.get(3) + " -i " + parameters.get(0) + " " + parameters.get(1));
				//ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "D:/OOP/NarezkaFailov/ffmpeg/bin/ffmpeg.exe", "-ss", "00:01:00", "-t", "00:01:00", "-i", "D:/OOP/Videos/KastaMetla.mp4", "D:/OOP/Videos/Narezka_JAVA/KastaMetla/Kasta1-1.mp4");
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", program, "-ss", parameters.get(2), "-t", parameters.get(3), "-i", parameters.get(0), parameters.get(1));
				Process process = builder.start();
				} catch (IOException e){ /*Закрытие оператора исключения и с последующем его описанием*/
					System.out.println("Процесс не создан!");
				}
		}
		
		private void endOffile() {
				
		}
		
		private int timeOfsubstr(String str) {
			
			int convtime;
			
			int sec_hour;
			int sec_min;
			int sec;
			
			Pattern pt = Pattern.compile("(\\d+):(\\d+):(\\d+)");
			Matcher m = pt.matcher(str);
			
			if(m.find()) {
			sec_hour = Integer.parseInt(m.group(1))*3600;
			sec_min = Integer.parseInt(m.group(2))*60;
			sec = Integer.parseInt(m.group(3)); System.out.println("sec_hour = " + sec_hour + ", sec_min = " + sec_min + ", sec = " + sec);
			
			convtime = sec_hour + sec_min + sec;
		
			return convtime;
			}
			return 0;
		}
		
		private String differnceOfsubstr(int start, int finish) {
			
			String conv = new String();
			int intconv = finish - start; System.out.println("intconv = " + intconv); 
			LocalTime time = LocalTime.ofSecondOfDay(intconv);
			// ISO Format
		    DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		    conv = time.format(timeFormatter); System.out.println(conv);
			
			return conv;
			
		}
		
		private String searchOfmenu(String fileName) {
			// D:\\OOP\\Videos\\textfile_java.txt
			String pathName = new String();
			String endName;
			Vector <String> pathStr;
			int j;
			int iSize;
			int iIndex;
			
			iSize = pathEndStrings.size();
			
			for (int i = 0; i < iSize; i++) {
				
				pathStr = pathEndStrings.get(i);
				endName = pathStr.get(0); System.out.println("fileName = " + fileName + "  endName = " + endName);
				iIndex = fileName.indexOf(endName); System.out.println("iIndex = " + iIndex);
				
				if (iIndex > -1) { System.out.println("if true");
					pathName = pathStr.get(1);
					
					i = iSize;
					
					return pathName;
				}
			}
			
			return pathName;
		}
		
		private String formOfpath(String fileName, String substr) {
			String childPath = new String();
			
			int index = fileName.lastIndexOf(".mp4");
			//Вырезать подстроку из строки	
			childPath = fileName.substring(0, index); 
			childPath = cutFolder + "/" + childPath + "/" + substr; //System.out.println("childPath = " + childPath);
			
			return childPath;
		}
		
		private Vector <String> parametersOfstr(String menuName,String childPath, String substr, String convsubstr) {
		
			Vector <String> str = new Vector <String>();
			
			str.add(menuName.replace("\\", "/"));
			str.add(childPath);
			str.add(substr);
			str.add(convsubstr);
			
			return str;
		}
		
		private String foldOfPath(String fileName) {
			
			String childPath = new String();
			
			int index = fileName.lastIndexOf(".mp4");
			//Вырезать подстроку из строки	
			childPath = fileName.substring(0, index); 
			childPath = cutFolder + "/" + childPath + "/";
			
			return childPath;
		}
		
		private void arrayOffolders(String folder) {
		
			int index = convertFolders.indexOf(folder);
			
			//Если такого пути в папках ещё нет, то
			if(index == -1) {
				convertFolders.add(folder);
			}
		}
	    
    /////////	    
	}
	
	public class ethernetFrame extends JInternalFrame
	{
		//Создание поля  
	    JTextField bigField1;
	    
	  //Cоздание многострочных полей
	    JTextArea textArea;
	    
	    //Флаг разрешения передачи: true - разрешена
	    boolean allowData; 
	    
	    //Флаг того, что данное новое: true - новое
	    //private String newData;
	    
	    //public String Data;
	    
	    public ethernetFrame()
	    {
	        super("Ethernet");//, true, true, true, true );
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        // Создание панели c возможностью позиционирования
	        JPanel contents = new JPanel();
	        contents.setLayout(null);
			
			ButtonGroup group = new ButtonGroup();
			JRadioButton serverButton = new JRadioButton("Сервер", false);
			serverButton.setBounds(1, 1, 180, 30);
			group.add(serverButton);
			contents.add(serverButton);
			
			JRadioButton clientButton = new JRadioButton("Клиент", true);
			clientButton.setBounds(200, 1, 180, 30);
			group.add(clientButton);
			contents.add(clientButton);
			
			//Создание кнопки
	        JButton add1 = new JButton("Запустить");
	        add1.setBounds(1, 50, 120, 30);
	        contents.add(add1);
	        
	      //Создание кнопки
	        JButton add2 = new JButton("Отсоединить");
	        add2.setBounds(1, 80, 120, 30);
	        contents.add(add2);
			
			//Создание поля  
	        bigField1 = new JTextField("Введите IP сервера/клиента", 25);
	        bigField1.setBounds(130, 50, 180, 30);
	        contents.add(bigField1);
	        
	        //Cоздание многострочных полей
	        textArea = new JTextArea("Вывод данных, получаемых сервером\n", 20, 10);
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        // Шрифт и табуляция
	        textArea.setFont(new Font("Dialog", Font.PLAIN, 14));
	        textArea.setTabSize(100);
	        scrollPane.setBounds(1, 120, 310, 300);
	        contents.add(scrollPane);
	        
	        //////////Для примера
	        
	        //allowData = true;
	        newData = false;
	        //setnewData("0");
	        
	       //Data = "Сообщение 1";
	        
	        //////////
	        
	        add1.addActionListener(

	                new ActionListener() {

	                   public void actionPerformed( ActionEvent e ) {

	                	   System.out.println("Программа запущена!");
	                	   
	                	   if (clientButton.isSelected()) {
	                		   System.out.println("Программа запущена как клиент!");
	           		   
	                		   clientModuleThread clientModuleTh = new clientModuleThread();
	                		   clientModuleTh.start();

	                	   }
	                	   else if (serverButton.isSelected()) {
	                		   System.out.println("Программа запущена как сервер!");
	 
	                		   serverModuleThread serverModuleTh = new serverModuleThread();
	                 		   serverModuleTh.start();
	                	   }

	                   }

	                }

	             );
	        
	        add2.addActionListener(

	                new ActionListener() {

	                   public void actionPerformed( ActionEvent e ) {

	                	   System.out.println("Программа отсоединена!");

	                   }

	                }

	             );
	        
			
			setContentPane(contents);
	    }
    
	    public class serverModuleThread extends Thread {
			
			//Серверный сокет для принятия сообщений с клиента
			private ServerSocket server;
			
			//Соокет для отправки ответных сообщений с клиента
			private Socket client;
			
			private DataInputStream in;
			
			private DataOutputStream out;
			
			public void run() {
		        System.out.println("Переход внутрь потока модуля-сервера!");
		        
		      //Пример: 
				String inClient = "str";
				
				String quit = "quit";
				
				try {
				//Серверный сокет для принятия сообщений с клиента
				server = new ServerSocket(60);

				System.out.println("Wait client...");
				
				//Ожидание подключения клиента
				client = server.accept();
				
				System.out.println("Client connected!");
					
				in = new DataInputStream(client.getInputStream());
					
				out = new DataOutputStream(client.getOutputStream());	
	      
		        //int i = 0;
		        while(true) {
				
					inClient = in.readUTF();
					
					out.writeUTF(quit);
									
			        if (inClient == "quit") {
			        	
			        	in.close();
			        	out.close();
			        	client.close();
			        	}
			        else {
			        	textArea.append(inClient);
			        }

		        } 
		        
		        } catch(IOException e){ /*Закрытие оператора исключения и с последующем его описанием*/

				}
		    }
		}
		    
		public class clientModuleThread extends Thread {

			private Socket connect;
			
			private DataOutputStream out;
			
			private DataInputStream in;
		
			public void run() {
		            System.out.println("Переход внутрь потока модуля-клиента!");
		            
		          //Пример:
		    		String str1 = "Сообщение 1";
		    		String answer;
		    		String newDataflag;
		            
			            try {
			            	connect = new Socket(bigField1.getText(),60);
			            	
			            	out = new DataOutputStream(connect.getOutputStream());
							
							in = new DataInputStream(connect.getInputStream());
			    			
			    	        while(true) {
			    	        	
			    	        	//Блок ухода в сон и ожидания обработки. Без этого не работает посылка сообщений
			    	        	try {
			    	        		Thread.sleep(10);
			    	        	} catch (InterruptedException e) {
			    	                System.out.println("Работа потока была прервана");
			    	                break;
			    	            }
		    	        		
				    			if (newData == true) {
					    	        //Отправка данных в клиент в стандартный поток
					    			out.writeUTF(Data + "\n");
					    			out.flush();
		    			
				    			//Ждём ответа от сервера
				    			answer = in.readUTF();
				    			
				    			newData = false;
				    			
				    			if (answer == "quit") {
				    				out.close();
					    			connect.close();
				    				
				    				}

				    			}
			    			
			    	        }
			    			
			    		} catch(IOException e){ /*Закрытие оператора исключения и с последующем его описанием*/
			    			System.out.println("Работа потока была прервана");
			    		}
       
		    		//}
		    }
		}
	}
	
	public class registratorFrame extends JInternalFrame
	{
	    public registratorFrame()
	    {
	        super("Registrator");

	        JPanel contents = new JPanel();
	        contents.setLayout(null);
	        
	      //Создание кнопки
	        JButton add1 = new JButton("Получить время и видео");
	        add1.setBounds(1, 1, 180, 30);
	        contents.add(add1);
	        
	      //Создание кнопки
	        JButton add2 = new JButton("Сформировать список");
	        add2.setBounds(1, 30, 180, 30);
	        contents.add(add2);
	        
	        setContentPane(contents);
	        
	        /* Событие "Нажатие кнопки "Получить время и видео" */
	        add1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		        	
		        	  System.out.println("Кнопка получения данных о времени и видео с видеорегистратора");
		          }
		      });
	        
	        /* Событие "Нажатие кнопки "Сформировать список" */
	        add2.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		        	
		        	  System.out.println("Кнопка формирования лога для нарезки файлов из логов модуля EthernetFrame и полученных\n с регистратора данных о времени.");
		          }
		      });
	    }
	}
}