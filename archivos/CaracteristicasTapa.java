
public class CaracteristicasTapa{
	private String nCliente = "";
	private String lote = "";
	private double gramos = 0.0;
	private double metros = 0.0;
	private String incidencia = "";
	private double pesoMandril = 412.5;//Peso del mandril 412.5 gramos
	private double peso1mtapa = 15.51;//15.51 gramos = 1 metro lineal tapa (equivalencia sin mandril)
	private static double metrosTapaTotal = 0;
	
	
	public CaracteristicasTapa(String nC, String l, double g,String i){
		this.nCliente = nC.toUpperCase();
		this.lote = l;
		this.gramos = g;
		this.incidencia = i.toUpperCase();	
	}
	
	public String getNombreCliente(){
		int tamaNo = this.nCliente.length();
		for(int n = tamaNo; n<45;n++)
		{
			this.nCliente+=" ";
		}
		
		return this.nCliente;
	}
	public String getLote(){
		int tamaNo = this.lote.length();
		if (tamaNo==0)
		{
			setModificarLote();
			tamaNo=13;
		}
		for(int n = tamaNo; n<20;n++)
		{
			this.lote+=" ";
		}
		return this.lote;
	}
	public double getGramos(){
		return this.gramos;
	}
	public String getMetros(){
		this.metros = (this.gramos-pesoMandril)/peso1mtapa;
		/*int entero = (int)this.metros;
		double aux = this.metros - entero;
		aux = aux*100;
		double auxEntero = (int)aux; 
		aux = auxEntero/100;
		double resultado = entero+aux;*/
		
		double resultado = getRedondeo(this.metros);
		metrosTapaTotal+=resultado;
		String strResultado = Double.toString(resultado);
		strResultado+="mL~";
		
		int tamaNo = strResultado.length();
		for(int n = tamaNo; n<15;n++)
		{
			strResultado+=" ";
		}
		
		return strResultado;
	}
	public String getIncidencia(){
		return this.incidencia;
	}
	
	public void setIncidencia(String i){
		this.incidencia = i;
	}
	public void setModificarLote(){
		this.lote = "NO DISPONIBLE";
	}
	public static double getMetrosTotales(){
		return metrosTapaTotal;
	}
	public double getRedondeo(double n){
		int entero = (int)n;
		double aux = n - entero;
		aux = aux*100;
		double auxEntero = (int)aux; 
		aux = auxEntero/100;
		double resultado = entero+aux;
		return resultado;
	}
	}



