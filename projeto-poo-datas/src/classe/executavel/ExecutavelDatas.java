package classe.executavel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ExecutavelDatas {

	public static void main(String[] args) throws ParseException, InterruptedException {
		Date date = new Date();
		
		System.out.println(date);
		
		System.out.println("Data em milesegundos "+date.getTime());
		
		System.out.println("Dia do mês "+date.getDate());
		
		System.out.println("Ano "+ (date.getYear() + 1900));
		
		//Formatando datas
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Data atual: "+simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Data para BD: "+simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Data com horas: "+simpleDateFormat.format(date));
		
		simpleDateFormat.parse("1982-07-08 20:10:07");
		
		System.out.println(simpleDateFormat.parse("1982-07-08 20:10:07"));
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(simpleDateFormat.parse("08/07/1982"));
		
		
		System.out.println("--------------------------------------------------");
		//-----------------------CALENDAR-------------------------
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("Data em milesegundos "+calendar.getTimeInMillis());
		
		System.out.println("Dia do mês "+calendar.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("Dia da semana "+calendar.get(Calendar.DAY_OF_WEEK));
		
		System.out.println("Hora do dia "+(calendar.get(Calendar.HOUR_OF_DAY)-1));
		
		System.out.println("Minuto "+calendar.get(Calendar.MINUTE));
		
		System.out.println("Segundo "+calendar.get(Calendar.SECOND));
		
		System.out.println("Ano "+calendar.get(Calendar.YEAR));
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Formatação "+simpleDateFormat.format(calendar.getTime()));

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Formatação "+simpleDateFormat.format(calendar.getTime()));
		
		
		System.out.println("--------------------------------------------------");
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataVencimentoBoleto = simpleDateFormat.parse("15/12/2021");
		
		Date dataAtual = simpleDateFormat.parse("16/11/2021");
		
		//After: data 1 maior que data 2
		//before: data 1 menor que data 2
		if(dataVencimentoBoleto.after(dataAtual)) {//data 1 maior q a data 2?
			System.out.println("Boleto não vencido");
		}else {
			System.out.println("Boleto vencido");
		}
		
		if(dataVencimentoBoleto.before(dataAtual)) {//data 1 menor q a data 2?
			System.out.println("Boleto vencido");
		}else {
			System.out.println("Boleto não vencido");
		}
		
		System.out.println("--------------------------------------------------");
		
		long dias = ChronoUnit.DAYS.between(LocalDate.parse("2021-01-01"), LocalDate.now());
		
		System.out.println("Passaram "+dias+" dias...");
		 
		long meses = ChronoUnit.MONTHS.between(LocalDate.parse("2021-01-01"), LocalDate.now());
		 
		System.out.println("Passaram "+meses+" meses...");
		
		System.out.println("--------------------------------------------------");
		
		Calendar calendar1 = Calendar.getInstance();
		
		calendar1.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("19-11-2021"));
		
		calendar1.add(Calendar.DAY_OF_MONTH, -11);
		
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendar1.getTime()));
		
		calendar1.add(Calendar.MONTH, 2);
		
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendar1.getTime()));
		
		Calendar calendar2 = Calendar.getInstance();
		Date dataInicial = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-19");
		
		calendar2.setTime(dataInicial);
		
		for(int i=1;i<=12;i++) {
			calendar2.add(Calendar.MONTH, 1);
			System.out.println("Parcela número: "+i+" vencimento é em: "
					+new SimpleDateFormat("dd/MM/yyyy").format(calendar2.getTime()));
			
		}
		System.out.println("--------------------------------------------------");
		//API de data JAVA 8
		
		LocalDate dataHoje = LocalDate.now();
		System.out.println("Data: "+dataHoje);
		
		LocalTime horaAtual = LocalTime.now();
		System.out.println("Hora: "+horaAtual);
		
		LocalDateTime dataHora = LocalDateTime.now();
		System.out.println("Data e Hora: "+dataHora);
		
		//Formatando
		System.out.println("Data e Hora formatados: "+dataHora.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("Data e Hora formatados: "+dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		LocalDate localDate = LocalDate.now();
		System.out.println("Data atual formatada: "+localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("Dia da semana: "+localDate.getDayOfWeek());
		System.out.println("Dia do mês: "+localDate.getDayOfMonth());
		System.out.println("Dia do ano: "+localDate.getDayOfYear());
		System.out.println("Mês: "+localDate.getMonth());
		System.out.println("Ano: "+localDate.getYear());
		
		//tempos
		
		Instant inicio = Instant.now();
		
		Thread.sleep(1000);
		
		Instant ifinal = Instant.now();
		
		Duration duration = Duration.between(inicio, ifinal);
		
		System.out.println("Nano: "+duration.toNanos());
		System.out.println("Milesegundo: "+duration.toMillis());
		System.out.println("Minutos: "+duration.toMinutes());
		System.out.println("Hora: "+duration.toHours());
		
		//Períodos entre datas
		LocalDate localDate2 = LocalDate.of(2019, 7, 1);
		LocalDate localDate3 = LocalDate.of(2021, 11, 19);
		
		System.out.println("Data antiga é maior que data nova: "+localDate2.isAfter(localDate3));
		System.out.println("Data antiga é anterior a data nova: "+localDate2.isBefore(localDate3));
		System.out.println("Datas iguais: "+localDate2.isEqual(localDate3));
		
		Period period = Period.between(localDate2, localDate3);
		System.out.println("Período é: "+period.getYears()+" anos "+period.getMonths()+" meses e "
				+period.getDays()+" dias");
		System.out.println(period.toTotalMonths());
		
		//Add tempos
		LocalDate dataBase = LocalDate.parse("2021-11-19");
		System.out.println("Data base: "+dataBase);
		System.out.println("Mais 5 dias: "+(dataBase = dataBase.plusDays(5)));
		System.out.println("Mais 4 semana: "+(dataBase = dataBase.plusWeeks(4)));
		System.out.println("Mais 7 meses: "+(dataBase = dataBase.plusMonths(7)));
		System.out.println("Mais 2 anos : "+(dataBase = dataBase.plusYears(2)));
		System.out.println("Menos 1 ano: "+(dataBase = dataBase.minusYears(1)));

	}

}
