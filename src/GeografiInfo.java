
public class GeografiInfo {
	public class MeteorologiInfo {
		//Dette er kun placeholders for infotyper
		private float meterOverHavet;
		private String koordinater;
		
		public MeteorologiInfo(float meterOverHavet, String koordinater) {
			this.meterOverHavet = meterOverHavet;
			this.koordinater = koordinater;
		}
		
		public float meterOverHavet(){
			return this.meterOverHavet;
		}
		
		public String getKoordinater(){
			return this.koordinater;
		}	
	}
	
}
