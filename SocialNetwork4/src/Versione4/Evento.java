package Versione4;

import java.io.File;
import java.sql.Time;
import java.util.*;
import mylib.InputDati;

public class Evento {

	private static final boolean FACOLTATIVO=false;
	private static final boolean OBBLIGATORIO=true;
	public static final int FIRST_PAGE=0;
	public static final String TITOLO="Titolo";
	private static final String DESCR_TITOLO="Il titolo che vuoi dare al tuo evento";
	public static final String NUM_PART="Numero di partecipanti";
	private static final String DESCR_NUM_PART="Il numero di persone che possono partecipare all'evento";
	public static final String TERM_ULT_ISCR="Termine ultimo di iscrizione";
	private static final String DESCR_TERM_ULT_ISCR="Ultimo giorno utile per iscriversi all'evento";
	public static final String LUOGO="Luogo";
	private static final String DESCR_LUOGO="Indirizzo del luogo che ospiter� l'evento oppure, se l'evento � itinerante, il luogo di ritrovo";
	public static final String DATA="Data";
	private static final String DESCR_DATA="Data in cui si svolge l'evento o, nel caso l'evento duri pi� giorni, la data di inizio";
	public static final String ORA="Ora";
	private static final String DESCR_ORA="Orario di ritrovo";
	public static final String DURATA="Durata";
	private static final String DESCR_DURATA="Durata approssimativa in ore e minuti, per gli eventi che si esauriscono in un solo giorno, o in termini di numero esatto di giorni, per gli eventi che occupani pi� giorni";
	public static final String QUOTA="Quota individuale";
	private static final String DESCR_QUOTA="La spesa che ogni partecipante all'iniziativa dovr� sostenere";
	public static final String COMPRESO_QUOTA="Compreso nella quota";
	private static final String DESCR_COMPRESO_QUOTA="Tutte le voci di spesa che sono comprese nella \"Quota individuale\"";
	public static final String DATA_FIN="Data conclusiva";
	private static final String DESCR_DATA_FIN="Data in cui l'evento si conclude";
	public static final String ORA_FIN="Ora conclusiva";
	private static final String DESCR_ORA_FIN="Orario di conclusione dell'evento";
	public static final String NOTE="Note";
	private static final String DESCR_NOTE="Informazioni aggiuntive circa l'evento";
	public static final String TOLLERANZA_PARTECIPANTI="Tolleranza numero di partecipanti";
	private static final String DESCR_TOLLERANZA_PARTECIPANTI="Numero di partecipanti in esubero che al massimo sono tollerati rispetto al \"Numero di partecipanti\"";
	public static final String TERMINE_RITIRO_ISCR="Termine ultimo di ritiro iscrizione";
	private static final String DESCR_TERMINE_RITIRO_ISCR="Data entro cui a ogni fruitore che ha aderito all�evento � concesso di cancellare la sua iscrizione e al fruitore che ha proposto l�evento di ritirare la proposta";
	public static final String MESSAGGIO_FACOLTATIVO="\nVuoi inserire il valore del campo ";
	public static final String MESSAGGIO_CAMPO="\nInserisci il valore del campo \"";
	public static final String FINE_MESSAGGIO_CAMPO="\": ";
	private final static String MESSAGGIO_DURATA="\nL'evento si conclude nell'arco di una giornata?";
	public static final int TOLLERANZA_MIN=0;
	private static final int MIN_QUOTA=0;
	private static final int MIN_PARTECIPANTI=2;
	public static final String[] CAMPI_STR= {TITOLO, LUOGO, COMPRESO_QUOTA, NOTE};
	public static final String[] CAMPI_INT= {NUM_PART, TOLLERANZA_PARTECIPANTI};
	public static final String[] CAMPI_DOUBLE= {QUOTA};
	public static final String[] CAMPI_DATE= {TERM_ULT_ISCR, DATA, DATA_FIN, TERMINE_RITIRO_ISCR};
	public static final String[] CAMPI_TIME= {ORA, DURATA, ORA_FIN};
	private static final String FILE_EVENT="d:/Progetto Zanella/FileEventi/FileEventi.xlsx";
	public static final String FILE_UTENTI_EVENTI="d:/Progetto Zanella/FileEventi/FileUtentiEventi.xlsx";
	public static final int EVENT_NOME_ROW=0;
	public static final int EVENT_DESCRIZIONE_ROW=1;
	public static final int EVENT_STATO_ROW=2;
	public static final int EVENT_TITLE_ROW=3;
	public static final int EVENT_NUM_PART_ROW=4;
	public static final int EVENT_TERM_ISCR_ROW=5;
	public static final int EVENT_LUOGO_ROW=6;
	public static final int EVENT_DATA_IN_ROW=7;
	public static final int EVENT_ORA_IN_ROW=8;
	public static final int EVENT_DURATA_ROW=9;
	public static final int EVENT_QUOTA_ROW=10;
	public static final int EVENT_COMPRESO_QUOTA_ROW=11;
	public static final int EVENT_DATA_FIN_ROW=12;
	public static final int EVENT_ORA_FIN_ROW=13;
	public static final int EVENT_NOTE_ROW=14;
	public static final int EVENT_TOLLERANZA_PARTECIPANTI_ROW=15;
	public static final int EVENT_TERMINE_RITIRO_ISCR_ROW=16;
	private static final String CAMPO_ERRATO="Il campo cercato non � di tipo ";
	public static File FILE_UT_EV=new File(FILE_UTENTI_EVENTI);
	public static File FILE_EV=new File(FILE_EVENT);
	private Campo <String> titolo=new Campo<>(TITOLO, DESCR_TITOLO, FACOLTATIVO);
	private Campo <Integer> numPartecipanti=new Campo<>(NUM_PART, DESCR_NUM_PART, OBBLIGATORIO);
	private Campo <Date> termIscr=new Campo<>(TERM_ULT_ISCR, DESCR_TERM_ULT_ISCR, OBBLIGATORIO);
	private Campo <String> luogo=new Campo<>(LUOGO, DESCR_LUOGO, OBBLIGATORIO);
	private Campo <Date> dataIn=new Campo<>(DATA, DESCR_DATA, OBBLIGATORIO);
	private Campo <Time> oraIn=new Campo<>(ORA, DESCR_ORA, OBBLIGATORIO);
	private Campo durata=new Campo<>(DURATA, DESCR_DURATA, FACOLTATIVO);
	private Campo <Double> quota=new Campo<>(QUOTA, DESCR_QUOTA, OBBLIGATORIO);
	private Campo <String> compresoQuota=new Campo<>(COMPRESO_QUOTA, DESCR_COMPRESO_QUOTA, FACOLTATIVO);
	private Campo <Date> dataFin=new Campo<>(DATA_FIN, DESCR_DATA_FIN, FACOLTATIVO);
	private Campo <Time> oraFin=new Campo<>(ORA_FIN, DESCR_ORA_FIN, FACOLTATIVO);
	private Campo <String> note=new Campo<>(NOTE, DESCR_NOTE, FACOLTATIVO);
	private Campo <Integer> tolleranzaPart=new Campo<>(TOLLERANZA_PARTECIPANTI, DESCR_TOLLERANZA_PARTECIPANTI, FACOLTATIVO);
	private Campo <Date> termRitiroIscr=new Campo<>(TERMINE_RITIRO_ISCR, DESCR_TERMINE_RITIRO_ISCR, FACOLTATIVO);
	private int column;
	public static final int NUM_CAMPI=16;
	
	public enum Stato {
		APERTA,
		CHIUSA,
		CONCLUSA,
		FALLITA,
		RITIRATA;
		}
	
	private Stato stato;

	private String nome; 
	private String descrizione;
	private ArrayList<Campo> campi=new ArrayList<>();
	
	public Evento(int column) {
		this.column=column;
		nome=ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE).get(EVENT_NOME_ROW);
		descrizione=ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE).get(EVENT_DESCRIZIONE_ROW);
		stato=Stato.valueOf(ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE).get(EVENT_STATO_ROW));
		addCampi();
		inizializzaCampiDaFile();
	}
	
	public Evento(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		stato=Stato.APERTA;
		addCampi();
		column=ExcelUtility.getEventNum();
	}
	
	public int getPartAtt() {
		return ExcelReader.takeColumn(FILE_UT_EV, column, FIRST_PAGE).size();
	}
	
	public boolean creatore(Utente u) {
		ArrayList<String> nomiUtenti=Utility.getNomiUtenti(getUtenti());
		if(u.getId().equals(nomiUtenti.get(0))) {
			return true;
		}
		return false;
	}
	
	public String mostraEv() {
		return Interfaces.mostraEvento(this);
	}

	private void inizializzaCampiDaFile() {
		ArrayList<String> colonna=ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE);
		if(!colonna.get(EVENT_TITLE_ROW).equals(ExcelReader.NO_VALUE)) setValCampo(TITOLO, colonna.get(EVENT_TITLE_ROW));
		setValCampo(NUM_PART, Integer.parseInt(colonna.get(EVENT_NUM_PART_ROW)));
		setValCampo(TERM_ULT_ISCR, mylib.Utility.StringToDate(colonna.get(EVENT_TERM_ISCR_ROW)));
		setValCampo(LUOGO, colonna.get(EVENT_LUOGO_ROW));
		setValCampo(DATA, mylib.Utility.StringToDate(colonna.get(EVENT_DATA_IN_ROW)));
		setValCampo(ORA, Time.valueOf(colonna.get(EVENT_ORA_IN_ROW)));
		if(!colonna.get(EVENT_DURATA_ROW).equals(ExcelReader.NO_VALUE)) {
			if(colonna.get(EVENT_DURATA_ROW).indexOf(":")==-1) {
				setValCampo(DURATA, Integer.parseInt(colonna.get(EVENT_DURATA_ROW)));
			}
			else setValCampo(DURATA, Time.valueOf(colonna.get(EVENT_DURATA_ROW)));
		}
		setValCampo(QUOTA, Double.parseDouble(colonna.get(EVENT_QUOTA_ROW)));
		if(!colonna.get(EVENT_COMPRESO_QUOTA_ROW).equals(ExcelReader.NO_VALUE))setValCampo(COMPRESO_QUOTA, colonna.get(EVENT_COMPRESO_QUOTA_ROW));
		if(!colonna.get(EVENT_DATA_FIN_ROW).equals(ExcelReader.NO_VALUE)) setValCampo(DATA_FIN, mylib.Utility.StringToDate(colonna.get(EVENT_DATA_FIN_ROW)));
		if(!colonna.get(EVENT_ORA_FIN_ROW).equals(ExcelReader.NO_VALUE)) setValCampo(ORA_FIN, Time.valueOf(colonna.get(EVENT_ORA_FIN_ROW)));
		if(!colonna.get(EVENT_NOTE_ROW).equals(ExcelReader.NO_VALUE)) setValCampo(NOTE, colonna.get(EVENT_NOTE_ROW));
		setValCampo(TOLLERANZA_PARTECIPANTI, Integer.parseInt(colonna.get(EVENT_TOLLERANZA_PARTECIPANTI_ROW)));
		setValCampo(TERMINE_RITIRO_ISCR,  mylib.Utility.StringToDate(colonna.get(EVENT_TERMINE_RITIRO_ISCR_ROW)));
	}
	
	private void addCampi() {
		addCampo(titolo);
		addCampo(numPartecipanti);
		addCampo(termIscr);
		addCampo(luogo);
		addCampo(dataIn);
		addCampo(oraIn);
		addCampo(durata);
		addCampo(quota);
		addCampo(compresoQuota);
		addCampo(dataFin);
		addCampo(oraFin);
		addCampo(note);
		addCampo(tolleranzaPart);
		addCampo(termRitiroIscr);
	}

	public int getColumn() {
		return column;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public ArrayList<Campo> getCampi(){
		return campi;
	}
	
	private void cambiaStato(Stato s) {
		stato=s;
		ExcelReader.addToCell(s.name(), FILE_EV, column, EVENT_STATO_ROW, FIRST_PAGE);
	}
	
	private static void inizializzaNumeroReale(Campo <Double> c, int min, String s) {
		double valore=InputDati.leggiDoubleConMinimo(s, min);
		c.setValore(valore);
	}
	
	private static void inizializzaNumeroIntero(Campo <Integer> c, int min, String s) {
		int valore=InputDati.leggiInteroConMinimo(s, min);
		c.setValore(valore);
	}
	
	private static void inizializzaStringa(Campo <String> c, String s) {
		String str=InputDati.leggiStringaNonVuota(s);
		c.setValore(str);
	}
	
	private static void inizializzaData(Campo <Date> c, String s) {
		Date d=InputDati.leggiData(s);
		c.setValore(d);
	}
	
	private static void inizializzaDataConMinimo(Campo <Date> c, String s, Date min) {
		Date d=InputDati.leggiDataConMinimo(s, min);
		c.setValore(d);
	}
	
	private static void inizializzaDataConMassimoMinimo(Campo <Date> c, String s, Date max, Date min) {
		Date d=InputDati.leggiDataConMassimoMinimo(s, max, min);
		c.setValore(d);
	}
	
	private static void inizializzaOra(Campo <Time> c, String s) {
		Time t=InputDati.leggiTempo(s);
		c.setValore(t);
	}
	
	private static void inizializzaOraConMinimo(Campo <Time> c, String s, Time min) {
		Time t=InputDati.leggiTempoConMinimo(s, min);
		c.setValore(t);
	}
	
	private static void inizializzaDurata(Campo  c, String s, Time t, boolean oneDay) {
		Time durata;
		int durataGiorni;
		if(oneDay) {
			durata=InputDati.leggiDurata(s, t);
			c.setValore(durata);
		}
		else {
			durataGiorni=InputDati.leggiDurataDay(s);
			c.setValore(durataGiorni);
		}
	}
	
	public void inizializza(Campo c) {
		Date tomorrow=mylib.Utility.getTomorrowDate();
		boolean ok=true;
		if(!c.isObbligatorio()) {
			if(c.getValore()!=null) {
				ok=false;
			}
			else{
				if(c.getValore()==null) ok=InputDati.yesOrNo(MESSAGGIO_FACOLTATIVO+c.getNome()+"?");
				else ok=false;
			}
		}
		if(ok) {
			if(Utility.contenuto(CAMPI_STR, c.getNome())) inizializzaStringa(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);
			else if(Utility.contenuto(CAMPI_INT, c.getNome())) {
				if(c.getNome().equals(TOLLERANZA_PARTECIPANTI)) inizializzaNumeroIntero(c, TOLLERANZA_MIN, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);
				else inizializzaNumeroIntero(c, MIN_PARTECIPANTI, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);
			}
			else if(Utility.contenuto(CAMPI_DOUBLE, c.getNome())) inizializzaNumeroReale(c, MIN_QUOTA, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);
			else if(Utility.contenuto(CAMPI_DATE, c.getNome())) {
				if(c.getNome().equals(DATA_FIN)&&durata.getValore()==null) {
					inizializzaDataConMinimo(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, dataIn.getValore());
					durata.setValore(mylib.Utility.getDifferenceDays(dataIn.getValore(), dataFin.getValore()));
				}
				else if(c.getNome().equals(DATA)) inizializzaDataConMinimo(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, termIscr.getValore());
				else if(c.getNome().equals(TERMINE_RITIRO_ISCR)) inizializzaDataConMassimoMinimo(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, termIscr.getValore(), tomorrow);
				else inizializzaDataConMinimo(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, tomorrow);
			}
			else if(Utility.contenuto(CAMPI_TIME, c.getNome())) {
				if(c.getNome().equals(ORA_FIN)) {
						Date d=dataFin.getValore();
						if(d==null||d.compareTo(dataIn.getValore())==0) {
							inizializzaOraConMinimo(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, oraIn.getValore());
							durata.setValore(Time.valueOf(mylib.Utility.getDifferenceTime(oraFin.getValore(), oraIn.getValore())));
						}
						else inizializzaOra(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);		
				}
				else if(c.getNome().equals(ORA)) {
					inizializzaOra(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO);
				}
				else {
					boolean oneDay=InputDati.yesOrNo(MESSAGGIO_DURATA);
					inizializzaDurata(c, MESSAGGIO_CAMPO+c.getNome()+FINE_MESSAGGIO_CAMPO, oraIn.getValore(), oneDay);
					if(oneDay) {
						oraFin.setValore(Time.valueOf(mylib.Utility.getSumTime(oraIn.getValore(), (Time) durata.getValore())));
						dataFin.setValore(dataIn.getValore());
					}
					else {
						GregorianCalendar g=new GregorianCalendar();
						g.setTime(dataIn.getValore());
						dataFin.setValore(mylib.Utility.dateAfterDays(g, (int)durata.getValore()));
					}
				}
			}
		}
	}
	
	public boolean ritirabile() {
		if(mylib.Utility.getTodayDate().compareTo(termRitiroIscr.getValore())>0) return false;
		return true;
	}
	
	public void inizializzaEvento(Utente u) {
		for(int i=0; i<campi.size(); i++) {
			inizializza(campi.get(i));
		}
		inizializzaRimanente();
	}
	
	private void inizializzaRimanente() {
		if(dataFin.getValore()==null) dataFin.setValore(dataIn.getValore());
		if(termRitiroIscr.getValore()==null) termRitiroIscr.setValore(termIscr.getValore());
		if(tolleranzaPart.getValore()==null) tolleranzaPart.setValore(TOLLERANZA_MIN);
	}
	
	/*
	 * Precondizione: il nome del campo passato deve essere il nome di un campo esistente
	 */
	public Campo getCampo(String nome) {
		for(int i=0; i<campi.size(); i++) {
			if(campi.get(i).getNome().equals(nome)) {
				return campi.get(i);
			}
		}
		System.out.println("Campo inesistente");
		return null;
	}
	
	public String getValueCampoString(String nome) {
		for(int i=0; i<CAMPI_STR.length; i++) {
			if(CAMPI_STR[i].equals(nome)) return (String)getCampo(nome).getValore();
		}
		System.out.println(CAMPO_ERRATO+"String");
		return null;
	}
	
	public Integer getValueCampoInt(String nome) {
		for(int i=0; i<CAMPI_INT.length; i++) {
			if(CAMPI_INT[i].equals(nome)) {
				return (int)getCampo(nome).getValore();
			}
		}
		System.out.println(CAMPO_ERRATO+"Integer");
		return null;
	}
	
	public Time getValueCampoTime(String nome) {
		for(int i=0; i<CAMPI_TIME.length; i++) {
			if(CAMPI_TIME[i].equals(nome)) return (Time)getCampo(nome).getValore();
		}
		System.out.println(CAMPO_ERRATO+"Time");
		return null;
	}
	
	public Date getValueCampoDate(String nome) {
		for(int i=0; i<CAMPI_DATE.length; i++) {
			if(CAMPI_DATE[i].equals(nome)) return (Date)getCampo(nome).getValore();
		}
		System.out.println(CAMPO_ERRATO+"Date");
		return null;
	}
	
	public Double getValueCampoDouble(String nome) {
		for(int i=0; i<CAMPI_DOUBLE.length; i++) {
			if(CAMPI_DOUBLE[i].equals(nome)) return (double)getCampo(nome).getValore();
		}
		System.out.println(CAMPO_ERRATO+"Double");
		return null;
	}
	
	public void writeEvent() {
		File f=FILE_EV;
		ExcelReader.addToColumn(nome, f, column, FIRST_PAGE);
		ExcelReader.addToColumn(descrizione, f, column, FIRST_PAGE);
		ExcelReader.addToColumn(stato.toString(), f, column, FIRST_PAGE);
		for(int i=0; i<campi.size(); i++) {
			Campo c =campi.get(i);
			if(!Utility.contenuto(CAMPI_DATE, c.getNome())) {
				if(c.getValore()==null) ExcelReader.addToColumn(ExcelReader.NO_VALUE, f, column, FIRST_PAGE);
				else ExcelReader.addToColumn(""+c.getValore(), f, column, FIRST_PAGE);
			}
			else ExcelReader.addToColumn(mylib.Utility.DateToString((Date)c.getValore()), f, column, FIRST_PAGE);
		}
		ArrayList<Utente> utenti=getUtenti();
		for(int i=0; i<utenti.size(); i++) {
			ExcelReader.addToColumn(utenti.get(i).getId(), FILE_UT_EV, column, FIRST_PAGE);
		}
	}
	
	public void addCampo(Campo c) {
		campi.add(c);
	}
	
	/*
	 * Precondizioni: il nome del campo passato deve essere un campo esistente
	 *                il valore passato deve essere del tipo corretto rispetto al campo passato
	*/
	public <T> void setValCampo(String c, T valore) {
		getCampo(c).setValore(valore);
	}
	
	public Stato getStato() {
		return stato;
	}
	
	public int getPartMax() {
		String num=ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE).get(EVENT_TOLLERANZA_PARTECIPANTI_ROW);
		int toll=Integer.parseInt(num);
		int max=toll+getNumPart();
		return max;
	}
	
	public int getNumPart() {
		String num=ExcelReader.takeColumn(FILE_EV, column, FIRST_PAGE).get(EVENT_NUM_PART_ROW);
		return Integer.parseInt(num);
	}
	
	public void ritira() {
		cambiaStato(Stato.RITIRATA);
		ExcelUtility.writeNotify(this);
	}
	
	public void modificaStato() {
		Date today=mylib.Utility.getTodayDate();
		if(stato.equals(Stato.APERTA)) {
			ArrayList<Utente> utenti=getUtenti();
			if((utenti.size()>=getNumPart()&&utenti.size()<=getPartMax()&&today.after(termIscr.getValore()))||
					(termRitiroIscr.getValore().compareTo(today)<=0&&termIscr.getValore().after(today)&&utenti.size()==getPartMax())) {
				cambiaStato(Stato.CHIUSA);
				ExcelUtility.writeNotify(this);
			}
			else {
				if(mylib.Utility.getTodayDate().compareTo(termIscr.getValore())>=0){
					cambiaStato(Stato.FALLITA);
					ExcelUtility.writeNotify(this);
				}
			}
		}
		else {
			if(stato.equals(Stato.CHIUSA)&&mylib.Utility.getTodayDate().after(dataFin.getValore())){
				cambiaStato(Stato.CONCLUSA);
				ExcelUtility.addUtentiInvitabili(this);
			}
		}
	}
	
	public boolean addUtente(Utente u) {
		ExcelReader.addToColumn(u.getId(), FILE_UT_EV, column, FIRST_PAGE);
		return true;
	}
	
	public ArrayList<Utente> getUtenti() {
		ArrayList<String> strUtenti=ExcelReader.takeColumn(FILE_UT_EV, column, FIRST_PAGE);
		ArrayList<Utente> utenti=new ArrayList<>();
		for(int i=0; i<strUtenti.size(); i++) {
			utenti.add(ExcelUtility.takeUser(strUtenti.get(i)));
		}
		return utenti;
	}
	
	public Utente getCreatore() {
		ArrayList<Utente> utenti=getUtenti();
		for(int i=0; i<utenti.size(); i++) {
			if(creatore(utenti.get(i))) return utenti.get(i);
		}
		return null;
	}
}
