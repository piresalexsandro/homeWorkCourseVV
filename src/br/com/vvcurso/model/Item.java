package br.com.vvcurso.model;

import java.math.BigDecimal;
import java.util.List;

public class Item extends Pedido{
	
	private Integer codigoItem;
	private BigDecimal valorItem;
	private Integer qtdeItem;
	private String nomeItem;
	
	public Item() {
	}

	public Item(final Integer codigoItem, final BigDecimal valorItem, final Integer qtdeItem, String nomeItem) {
		super();
		this.codigoItem = codigoItem;
		this.valorItem = valorItem;
		this.qtdeItem = qtdeItem;
		this.nomeItem = nomeItem;
	}

	public Integer getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(final Integer codigoItem) {
		this.codigoItem = codigoItem;
	}

	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(final BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public Integer getQtdeItem() {
		return qtdeItem;
	}

	public void setQtdeItem(final Integer qtdeItem) {
		this.qtdeItem = qtdeItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(final String nomeItem) {
		this.nomeItem = nomeItem;
	}

	@Override
	public String toString() {
		return "\n 		Item " + codigoItem + ", " + valorItem + ", " + qtdeItem + ", " + nomeItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		result = prime * result + ((qtdeItem == null) ? 0 : qtdeItem.hashCode());
		result = prime * result + ((valorItem == null) ? 0 : valorItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		if (qtdeItem == null) {
			if (other.qtdeItem != null)
				return false;
		} else if (!qtdeItem.equals(other.qtdeItem))
			return false;
		if (valorItem == null) {
			if (other.valorItem != null)
				return false;
		} else if (!valorItem.equals(other.valorItem))
			return false;
		return true;
	}
}
