package com.cpssoft.web.test.accurate.widgets;

public enum WidgetsName {
	AKTIFITAS_TERAKHIR_ANDA("c_accurate__widget__recently-transaction-widget"),
	ASSET_SAAT_INI("c_accurate__widget__asset-growth-widget"),
	BARANG_PALING_LAKU("c_accurate__widget__top-frequently-item-widget"),
	BARANG_PERLU_DIPESAN("c_accurate__widget__item-to-reorder-widget"),
	BEBAN_PERUSAHAAN("c_accurate__widget__top-expense-widget"),
	HUTANG_USAHA("c_accurate__widget__purchase-widget"),
	JUMLAH_PELANGGAN("c_accurate__widget__customer-frequently-widget"),
	KEBERHASILAN_PENAWARAN("c_accurate__widget__quotation-success-widget"),
	KEGIATAN_MENDATANG("c_accurate__widget__upcoming-events-widget"),
	KEGIATAN_TERLEWAT("c_accurate__widget__missed-events-widget"),
	KETERSEDIAAN_KAS("c_accurate__widget__cash-availability-widget"),
	LABA_CABANG("c_accurate__widget__top-profit-branch-widget"),
	LABA_RUGI_TAHUN_INI("c_accurate__widget__profit-loss-widget"),
	PELANGGAN_BERHUTANG("c_accurate__widget__top-debt-customer-widget"),
	PENJUALAN_BARANG("c_accurate__widget__top-item-widget"),
	PENJUALAN_BULAN_INI("c_accurate__widget__sales-widget"),
	PENJUALAN_CABANG("c_accurate__widget__top-branch-widget"),
	PENJUALAN_PELANGGAN("c_accurate__widget__top-customer-widget"),
	PENJUALAN_PENJUAL("c_accurate__widget__top-salesman-widget"),
	PENJUALAN_PER_HARI("c_accurate__widget__sales-day-widget"),
	PERFORMA_PENJUAL("c_accurate__widget__salesman-target-widget"),
	PERMINTAAN_PEMBELIAN("c_accurate__widget__unprocess-purchase-requisition-widget"),
	PERSETUJUAN("c_accurate__widget__unprocess-approval-widget"),
	PERSETUJUAN_TERPROSES("c_accurate__widget__recently-approval-widget"),
	PESANAN_PEMBELIAN("c_accurate__widget__unreceive-purchase-order-widget"),
	PESANAN_PENJUALAN("c_accurate__widget__unprocess-sales-order-widget"),
	PIUTANG_USAHA("c_accurate__widget__receiveable-widget"),
	TRANSAKSI_PENJULAN("c_accurate__widget__sales-frequently-widget");
	
	private String id;

	private WidgetsName(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getXpath() {
		return "//div[contains(@id, 'dashboard-module')]//div[starts-with(@id, '" + id + "')]";
	}

}
