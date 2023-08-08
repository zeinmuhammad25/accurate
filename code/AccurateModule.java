package com.cpssoft.web.test.accurate.tool;

public enum AccurateModule {
	Widget ("module-accurate__dashboard"),
	
	AKUN_PERKIRAAN("module-accurate__general-ledger__glaccount"),
	
	ALAMAT("module-accurate__company__location"),
	
	ANGGARAN("module-accurate__budget-target__accountbudget-target"),
	
	ASET_PER_LOKASI("module-accurate__fixed-asset__asset-location"),
	
	PERSETUJUAN("module-accurate__company__approval"),
	
	ASET_TETAP("module-accurate__fixed-asset__fixed-asset"),
	
	BARANG_JASA("module-accurate__inventory__item"),
	
	BARANG_STOK_MINIMUM("module-accurate__inventory__minimum-stock-item"),
	
	CABANG("module-accurate__company__branch"),
	
	DAFTAR_LAPORAN("module-accurate__report__report"),
	
	DEPARTEMEN("module-accurate__company__department"),
	
	DESAIN_CETAKAN("module-accurate__company__print-layout"),
	
	DISPOSISI_ASET_TETAP("module-accurate__fixed-asset__fixed-asset-disposed"),
	
	FAKTUR_PEMBELIAN("module-accurate__vendor__purchase-invoice"),
	
	FAKTUR_PENJUALAN("module-accurate__customer__sales-invoice"),
	
	FOB("module-accurate__company__freeonboard"),
	
	GAJI("module-accurate__company__employee-fee"),
	
	GAJI_TUNJANGAN("module-accurate__company__employee-fee"),
	
	GUDANG("module-accurate__inventory__warehouse"),
	
	AKSES_GRUP("module-accurate__company__access-privilege"),
	
	HARGA_PEMASOK("module-accurate__inventory__vendor-price"),
	
	HISTORI_BANK("module-accurate__cash-bank__bank-book"),
	
	HISTORI_AKUN("module-accurate__general-ledger__account-history"),
	
	IMPOR_AKUN("module-accurate__general-ledger__glaccount-import"),
	
	IMPOR_BARANG("module-accurate__inventory__item-import"),
	
	IMPOR_PELANGGAN("module-accurate__customer__customer-import"),
	
	IMPOR_PEMASOK("module-accurate__vendor__vendor-import"),
	
	JURNAL_UMUM("module-accurate__general-ledger__journal-voucher"),
				
	KARYAWAN("module-accurate__company__employee"),
	
	KATEGORI_ANALISA("module-accurate__project__work-price-analysis-category"),
	
	KATEGORI_ASET("module-accurate__fixed-asset__fa-type"),
	
	KATEGORI_ASET_TETAP_PAJAK("module-accurate__fixed-asset__fiscal-fa-type"),
	
	KATEGORI_BARANG("module-accurate__inventory__item-category"),
	
	KATEGORI_HARGA("module-accurate__customer__price-category"),
	
	KATEGORI_PELANGGAN("module-accurate__customer__customer-category"),

	KATEGORI_PEMASOK("module-accurate__vendor__vendor-category"),
	
	KOMISI_PENJUAL("module-accurate__company__salesman-commission"),
	
	LOG_AKTIVITAS("module-accurate__company__audit"),
	
	MATA_UANG("module-accurate__company__currency"),
	
	PAJAK("module-accurate__company__tax"),
	
	PEKERJAAN_PESANAN("module-accurate__inventory__job-order"),
	
	PELANGGAN("module-accurate__customer__customer"),
	
	PEMASOK("module-accurate__vendor__vendor"),
	
	PEMBAYARAN("module-accurate__cash-bank__other-payment"),
	
	PENAMBAHAN_BAHAN_BAKU("module-accurate__inventory__material-adjustment"),
	
	PEMBAYARAN_GAJI("module-accurate__cash-bank__employee-payment"),
	
	PEMBAYARAN_PEMASOK("module-accurate__vendor__purchase-payment"),
	
	PENAWARAN_PENJUALAN("module-accurate__customer__sales-quotation"),
	
	PENERIMAAN("module-accurate__cash-bank__other-deposit"),
	
	PENCATATAN_BEBAN("module-accurate__general-ledger__expense-accrual"),

	PENCATATAN_GAJI("module-accurate__cash-bank__employee-payment"),
	
	PENERIMAAN_BARANG("module-accurate__vendor__receive-item"),
	
	PENERIMAAN_PENJUALAN("module-accurate__customer__sales-receipt"),
	
	PENGEPAKAN_BARANG("module-accurate__customer__delivery-packing"),
	
	PENGIRIMAN("module-accurate__company__shipment"),
	
	PENGIRIMAN_PESANAN("module-accurate__customer__delivery-order"),
	
	PENGISIAN_NOMOR_SERI("module-accurate__inventory__serial-number-entry"),
	
	PENOMORAN("module-accurate__company__auto-number"),
	
	PENOMORAN_PAJAK("module-accurate__company__tax-number"),
	
	PENYELESAIAN_PESANAN("module-accurate__inventory__roll-over"),
	
	PENYESUAIAN_HARGA_JUAL("module-accurate__inventory__sellingprice-adjustment"),
	
	PENYESUAIAN_PERSEDIAAN("module-accurate__inventory__item-adjustment"),
	
	PENYETUJU_TRANSAKSI("module-accurate__company__user-approval"),
	
	PERMINTAAN_BARANG("module-accurate__vendor__purchase-requisition"),
	
	PERSIAPAN_DATA("module-accurate__company__data-setup"),
	
	PERUBAHAN_ASET_TETAP("module-accurate__fixed-asset__fixed-asset-edited"),
	
	PESANAN_PEMBELIAN("module-accurate__vendor__purchase-order"),
	
	PESANAN_PENJUALAN("module-accurate__customer__sales-order"),
	
	PINDAH_ASET("module-accurate__fixed-asset__asset-transfer"),
	
	PINDAH_BARANG("module-accurate__inventory__item-transfer"),
	
	PREFERENSI("module-accurate__company__preferences"),
	
	PROSES_AKHIR_BULAN("module-accurate__company__period-end"),
	
	PROYEK("module-accurate__company__project"),
	
	RANCANGAN_FORMULIR("module-accurate__company__form-template"),
	
	REKAMAN_TRANSAKSI("module-accurate__company__memorize-transaction"),
	
	REKENING_KORAN("module-accurate__cash-bank__bank-statement"),
	
	REKONSILIASI_BANK("module-accurate__cash-bank__bank-reconcile"),
	
	RETUR_PEMBELIAN("module-accurate__vendor__purchase-return"),
	
	RETUR_PENJUALAN("module-accurate__customer__sales-return"),
	
	SATUAN_BARANG("module-accurate__inventory__unit"),
	
	SATUAN_UPAH_PEKERJA("module-accurate__project__labour-unit"),
	
	SETUP_AWAL("module-accurate__company__first-setup"),
	
	STOK_BARANG_PER_GUDANG("module-accurate__inventory__stock-warehouse"),
	
	STANDAR_BIAYA_PRODUKSI("module-accurate__fabrication__standard-product-cost"),
	
	RENCANA_PRODUKSI("module-accurate__fabrication__manufacture-order"),
	
	PENGAMBILAN_BAHAN_BAKU ("module-accurate__fabrication__material-slip"),
	
	ALOKASI_BIAYA_PRODUKSI ("module-accurate__fabrication__cost-distribution"),
	
	SYARAT_PEMBAYARAN("module-accurate__company__payment-term"),
	
	TARGET_PENJUALAN("module-accurate__budget-target__sales-target"),
	
	TARGET_PENJUALAN_BARANG("module-accurate__budget-target__itemsales-target"),
	
	TARGET_PENJUALAN_PENJUAL("module-accurate__budget-target__salesmansales-target"),
	
	TEKNISI("module-accurate__customer__technician"),
	
	TRANSAKSI_BERULANG ("module-accurate__company__recurring"),
	
	TRANSFER_BANK("module-accurate__cash-bank__bank-transfer"),
	
	TRANSAKSI_FAVORIT("module-accurate__company__memorize-transaction"),
	
	TUKAR_FAKTUR("module-accurate__customer__exchange-invoice"),
	
	UANG_MUKA_PEMBELIAN("module-accurate__vendor__purchase-downpayment"),
	
	UANG_MUKA_PENJUALAN("module-accurate__customer__sales-downpayment"),
	
	UPAH_PEKERJA("module-accurate__project__labour-cost"),
	
	KONTAK("module-accurate__company__contact"),
	
	UMUM(""),
	
	BARANG_PER_GUDANG("module-accurate__inventory__stock-warehouse"),

	LOG_AKTIVITAS_JURNAL("module-accurate__company__audit-journal"),
	
	HASIL_STOK_OPNAME("module-accurate__inventory__stock-opname-result"),
	
	PERINTAH_STOK_OPNAME("module-accurate__inventory__stock-opname-order"),	
	
	KLAIM_PEMASOK ("module-accurate__vendor__vendor-claim"),
	
	KLAIM_PELANGGAN ("module-accurate__customer__customer-claim"),
	
	PENGGUNA ("module-accurate__company__user-company"),
	
	BERITA ("module-accurate__company__news-page"),
	
	MARKETPLACE ("module-accurate__company__application"),
	
	FORMULA_PRODUKSI ("module-accurate__fabrication__bill-of-material"),
	
	PERINTAH_KERJA ("module-accurate__fabrication__work-order"),
	
	PENYELESAIAN_BARANG_JADI ("module-accurate__fabrication__finished-good-slip"),
	
	TAHAPAN_PROSES ("module-accurate__fabrication__process-stages"),
	
	TAHAPAN_PRODUKSI ("module-accurate__fabrication__bom-process-category"),
	
	DATA_KLASIFIKASI_1 ("module-accurate__company__data-classification-_-index1"),
	
	DATA_KLASIFIKASI_2 ("module-accurate__company__data-classification-_-index2"),
	
	DATA_KLASIFIKASI_3 ("module-accurate__company__data-classification-_-index3"),
	
	DATA_KLASIFIKASI_4 ("module-accurate__company__data-classification-_-index4"),
	
	DATA_KLASIFIKASI_5 ("module-accurate__company__data-classification-_-index5"),
	
	DATA_KLASIFIKASI_6 ("module-accurate__company__data-classification-_-index6"),
	
	DATA_KLASIFIKASI_7 ("module-accurate__company__data-classification-_-index7"),
	
	DATA_KLASIFIKASI_8 ("module-accurate__company__data-classification-_-index8"),
	
	DATA_KLASIFIKASI_9 ("module-accurate__company__data-classification-_-index9"),
	
	DATA_KLASIFIKASI_10 ("module-accurate__company__data-classification-_-index10"),
	
	SMARTLINK_ECOMMERCE ("module-accurate__customer__ecommerce-setting"),
	
	IMPOR_FAKTUR_PENJUALAN ("module-accurate__customer__sales-invoice-import"),
	
	IMPOR_FAKTUR_FROM_FILE ("module-accurate__customer__sales-invoice-import-file"),
	
	PENGATURAN_POS ("module-accurate__company__pos-setting"),
	
	PERAN_KARYAWAN_POS ("module-accurate__company__pos-employee-role"),
	
	IMPOR_ACCURATE_POS ("module-accurate__customer__manage-pos-import"),
	
	SMARTLINK_E_PAYMENT ("module-accurate__cash-bank__e-payment-history"),
	
	ACCURATE_STORE ("module-accurate__company__application"),
	
	TIPE_PENJUALAN ("module-accurate__company__pos-sales-type"),
	
	BIAYA ("module-accurate__company__pos-expense"),
	
	PEMENUHAN_PESANAN("module-accurate__inventory__backorder-inquiry"),

	;

	private String id;

	private AccurateModule(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getXpath() {
		return "//*[@id='" + id + "']";
	}
}
