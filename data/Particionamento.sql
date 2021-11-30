/*LEGENDAS: 
	FG = FILEGROUP,
	DF = DATAFILE,
	PF = PARTITION FUNCTION,
	PS = PARTITION SCHEME

OBS: Modificar o nome do seu banco de dados caso necessário, o meu está pythaoff
*/

/* Alteração na tabela FactAcesso para adicionar a função que particiona os dados por mês */
CREATE TABLE FactAcesso 
( 
 idDimTempo Integer,  
 idDimPerssoa Integer,  
 idDimCurso Integer,  
 idDimNote Integer,  
 qty_acesso INTEGER,  
 avg_nota INTEGER,  
 data_acesso datetime,
) ON PS_LogsMes(data_acesso); 


/* Criação dos Grupos de Arquivos para cada Mês*/
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogJaneiro
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogFevereiro
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogMarco
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogAbril
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogMaio
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogJunho
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogJulho
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogAgosto
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogSetembro
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogOutubro
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogNovembro
GO
ALTER DATABASE pythaoff ADD FILEGROUP FG_LogDezembro
GO

/*Criação dos Arquivos para cada Mês*/
ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Janeiro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogJaneiro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogJaneiro;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Fevereiro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogFevereiro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogFevereiro;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Marco, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogMarco.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogMarco;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Abril, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogAbril.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogAbril;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Maio, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogMaio.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB )
TO FILEGROUP FG_LogMaio;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Junho, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogJunho.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogJunho;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Julho, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogJulho.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogJulho;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Agosto, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogAgosto.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogAgosto;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Setembro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogSetembro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogSetembro;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Outubro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogOutubro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogOutubro;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Novembro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogNovembro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogNovembro;

ALTER DATABASE pythaoff
ADD FILE ( NAME = DF_Dezembro, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DF_LogDezembro.ndf', 
			SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 20MB ) TO FILEGROUP FG_LogDezembro;


/* Criação da função de particionamento por mês*/
CREATE PARTITION FUNCTION PF_LogsMes (datetime)
AS RANGE RIGHT FOR VALUES ('2021-02-01 00:00:00.000','2021-03-01 00:00:00.000','2021-04-01 00:00:00.000','2021-05-01 00:00:00.000','2021-06-01 00:00:00.000','2021-07-01 00:00:00.000','2021-08-01 00:00:00.000','2021-09-01 00:00:00.000','2021-10-01 00:00:00.000','2021-11-01 00:00:00.000','2021-12-01 00:00:00.000') ;
GO

/* Atribuição dos particionamentos para os Arquivos criados (informa ao banco de dados pra qual arquivo ele deve enviar os dados) */
CREATE PARTITION SCHEME PS_LogsMes
AS PARTITION PF_LogsMes
TO (FG_LogJaneiro, FG_LogFevereiro, FG_LogMarco, FG_LogAbril, FG_LogMaio, FG_LogJunho, 
	FG_LogJulho, FG_LogAgosto, FG_LogSetembro, FG_LogOutubro, FG_LogNovembro, FG_LogDezembro) ;
GO

/* Consulta os particionamentos existentes */
SELECT 
	OBJECT_NAME(P.object_id)   AS ObjectName
,	P.partition_number         AS PartitionNumber
,	FG.name                    AS FGName
,	P.rows                     AS [Rows]
,	(f.size * 8) / 1024        AS SizeMB
,	AU.used_pages              AS UsedPages
,	F.filename                 AS [FileName]
,	P.data_compression_desc    AS [Compression]
,	AU.type_desc               AS TypeDesc
,	S.name                     AS PartitionSchemeName
,	PF.name                    AS PartitionFunctionName
,	PF.boundary_value_on_right AS IsRightBoundary
,	R.value                    AS BoundaryValue
FROM 
			sys.tables AS T  
INNER JOIN	sys.indexes AS i  
				ON T.object_id = I.object_id  
INNER JOIN	sys.partitions AS P 
				ON i.object_id = p.object_id AND i.index_id = p.index_id   
INNER JOIN	sys.system_internals_allocation_units AS AU
				ON P.partition_id = AU.container_id
INNER JOIN	sys.filegroups AS FG
				ON AU.filegroup_id = FG.data_space_id 
INNER JOIN	sys.sysfiles AS F
				ON FG.data_space_id = F.groupid
INNER JOIN  sys.partition_schemes AS S   
				ON I.data_space_id = S.data_space_id  
INNER JOIN	sys.partition_functions AS PF   
				ON S.function_id = PF.function_id  
LEFT JOIN	sys.partition_range_values AS R
				ON PF.function_id = R.function_id 
				and R.boundary_id = P.partition_number  
WHERE 
	P.object_id = object_id('FactAcesso')
AND I.type <= 1 