# TDTestSolution
TDTestSolution
Merge all 3 data files into a single report

refdata and trade join by column Inventory
trade and valuation join by column TradeId

The output will be based on the Trade file.  If no valuation or refdata for a given trade, then leave the "refdata" and "valuation" fields BLANK

Ref Data column:
topOfHouse,segment,viceChair,globalBusiness,Policy,desk,portfolio,BU,CLINE,Inventory
Valuation column:
TradeId,UQL_OC_MMB_MS,UQL_OC_MMB_MS_PC
Trade column:
Inventory,Book,System,LegalEntity,TradeId,Version,TradeStatus,ProductType,Resetting Leg,ProductSubType,TDSProductType,SecCodeSubType,SwapType,Description,TradeDate,StartDate,MaturityDate

Output column:
topOfHouse,segment,viceChair,globalBusiness,Policy,desk,portfolio,BU,CLINE,Inventory,Book,System,LegalEntity,TradeId,Version,TradeStatus,ProductType,Resetting Leg,ProductSubType,TDSProductType,SecCodeSubType,SwapType,Description,TradeDate,StartDate,MaturityDate,UQL_OC_MMB_MS,UQL_OC_MMB_MS_PC,MS-PC,BreakStatus,Term


3 New Columns
-----column 1 
MS-PC = the different between column UQL_OC_MMB_MS and UQL_OC_MMB_PC
-----column 2
BreakStatus = the difference in Absolute(MS-PC) as following buckets:
0-99
100-999
1000-9999
10000-99999
100000+
-----column 3
Term = Column MaturityDate - Today. If MaturityDate is blank or already matured, set it as blank
0m-1m
1m-6m
6m-1yr
1yr-10yr
10yr-30yr
30yr-50yr
50yr+

Notes:
Design your program so that it can support multiple data sources (Here we have csv file, but we can switch to database, web service, or other 
Column should be name-based, instead of index-based to make it easy to insert/re-order.
