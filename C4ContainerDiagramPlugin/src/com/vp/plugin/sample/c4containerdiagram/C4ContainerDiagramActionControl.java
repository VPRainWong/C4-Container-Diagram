package com.vp.plugin.sample.c4containerdiagram;

import java.awt.Point;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IC4ModelContainerDiagramUIModel;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.connector.IC4modelRelationshipUIModel;
import com.vp.plugin.diagram.shape.IC4modelContainerUIModel;
import com.vp.plugin.diagram.shape.IC4modelPersonUIModel;
import com.vp.plugin.diagram.shape.IC4modelSoftwareSystemUIModel;
import com.vp.plugin.model.IC4modelContainer;
import com.vp.plugin.model.IC4modelPerson;
import com.vp.plugin.model.IC4modelRelationship;
import com.vp.plugin.model.IC4modelSoftwareSystem;
import com.vp.plugin.model.factory.IModelElementFactory;

public class C4ContainerDiagramActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Create blank C4 Container Diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IC4ModelContainerDiagramUIModel diagram = (IC4ModelContainerDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_C4_MODEL_CONTAINER_DIAGRAM);
		diagram.setName("Online Book Store - Container Diagram");
		
		// Create C4 Person model element
		IC4modelPerson customer = IModelElementFactory.instance().createC4modelPerson();
		customer.setName("Customer");
		// Create shape for the C4 Person
		IC4modelPersonUIModel customerShape = (IC4modelPersonUIModel) diagramManager.createDiagramElement(diagram, customer);
		customerShape.setBounds(100, 50, 150, 140);
		// Set to automatic calculate the initial caption position
		customerShape.setRequestResetCaption(true);

		// Create C4 Software System Model element		
		IC4modelSoftwareSystem onlineBookStore = IModelElementFactory.instance().createC4modelSoftwareSystem();
		onlineBookStore.setName("Online Book Store");
		// Create shape for C4 Software System 
		IC4modelSoftwareSystemUIModel onlineBookStoreShape = (IC4modelSoftwareSystemUIModel) diagramManager.createDiagramElement(diagram, onlineBookStore);
		onlineBookStoreShape.setBounds(340, 50, 740, 480);
		// Set to automatic calculate the initial caption position
		onlineBookStoreShape.setRequestResetCaption(true);
		
		// Create C4 Container model element
		IC4modelContainer webApp = IModelElementFactory.instance().createC4modelContainer();
		webApp.setName("Web Application");
		// Set it as UI Container type
		webApp.setContainerType(IC4modelContainer.CONTAINER_TYPE_UI_CONTAINER);
		// Specify technology property
		webApp.setTechnology("React, Node.js");
		// Create shape for C4 UI Container
		IC4modelContainerUIModel webAppshape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, webApp);
		webAppshape.setBounds(360, 89, 166, 124);
		// Add it as child of Online Book Store System Model
		onlineBookStore.addChild(webApp);
		onlineBookStoreShape.addChild(webAppshape);		
		// Set to automatic calculate the initial caption position
		webAppshape.setRequestResetCaption(true);
		
		// Create C4 Container model element
		IC4modelContainer apiGateway = IModelElementFactory.instance().createC4modelContainer();
		apiGateway.setName("API Gateway");
		// Set it as Backend Container type
		apiGateway.setContainerType(IC4modelContainer.CONTAINER_TYPE_BACKEND_CONTAINER);
		// Specify technology property
		apiGateway.setTechnology("Express.js, JWT");
		// Create shape for C4 Backend Container
		IC4modelContainerUIModel apiGatewayShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, apiGateway);
		apiGatewayShape.setBounds(630, 89, 166, 124);
		// Add it as child of Online Book Store System Model
		onlineBookStore.addChild(apiGateway);
		onlineBookStoreShape.addChild(apiGatewayShape);
		// Set to automatic calculate the initial caption position
		apiGatewayShape.setRequestResetCaption(true);
		
		// Create C4 Container model element
		IC4modelContainer bookService = IModelElementFactory.instance().createC4modelContainer();
		bookService.setName("Book Service");
		// Set it as Micro Service Container type
		bookService.setContainerType(IC4modelContainer.CONTAINER_TYPE_MICRO_SERVICE_CONTAINER);
		// Specify technology property
		bookService.setTechnology("Spring Boot");
		// Create shape for C4 Micro Service Container
		IC4modelContainerUIModel bookServiceShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, bookService);
		bookServiceShape.setBounds(890, 66, 168, 104);
		// Add it as child of Online Book Store System Model
		onlineBookStore.addChild(bookService);
		onlineBookStoreShape.addChild(bookServiceShape);
		// Set to automatic calculate the initial caption position
		bookServiceShape.setRequestResetCaption(true);
		
		IC4modelContainer userService = IModelElementFactory.instance().createC4modelContainer();
		userService.setName("User Service");
		userService.setContainerType(IC4modelContainer.CONTAINER_TYPE_MICRO_SERVICE_CONTAINER);
		userService.setTechnology("Spring Boot");
		IC4modelContainerUIModel userServiceShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, userService);
		userServiceShape.setBounds(890, 216, 168, 104);
		onlineBookStore.addChild(userService);
		onlineBookStoreShape.addChild(userServiceShape);
		userServiceShape.setRequestResetCaption(true);

		IC4modelContainer orderService = IModelElementFactory.instance().createC4modelContainer();
		orderService.setName("Order Service");
		orderService.setContainerType(IC4modelContainer.CONTAINER_TYPE_MICRO_SERVICE_CONTAINER);
		orderService.setTechnology("Spring Boot");
		IC4modelContainerUIModel orderServiceShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, orderService);
		orderServiceShape.setBounds(890, 367, 168, 104);
		onlineBookStore.addChild(orderService);
		onlineBookStoreShape.addChild(orderServiceShape);
		orderServiceShape.setRequestResetCaption(true);

		// Create C4 Container model element
		IC4modelContainer database = IModelElementFactory.instance().createC4modelContainer();
		database.setName("Database");
		// Set it as Storage Container type
		database.setContainerType(IC4modelContainer.CONTAINER_TYPE_STORAGE_CONTAINER);
		// Specify technology property
		database.setTechnology("PostgreSQL");
		// Create shape for C4 Storage Container
		IC4modelContainerUIModel databaseShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, database);
		databaseShape.setBounds(1180, 83, 130, 124);
		// Set to automatic calculate the initial caption position
		databaseShape.setRequestResetCaption(true);

		// Create C4 Container model element
		IC4modelContainer messageBroker = IModelElementFactory.instance().createC4modelContainer();
		messageBroker.setName("Message Broker");
		// Set it as Bus Container type
		messageBroker.setContainerType(IC4modelContainer.CONTAINER_TYPE_BUS_CONTAINER);
		// Specify technology property
		messageBroker.setTechnology("RabbitMQ");
		// Create shape for C4 Bus Container
		IC4modelContainerUIModel messageBrokerShape = (IC4modelContainerUIModel) diagramManager.createDiagramElement(diagram, messageBroker);
		messageBrokerShape.setBounds(1180, 380, 180, 82);
		// Set to automatic calculate the initial caption position
		messageBrokerShape.setRequestResetCaption(true);
		
		// Create relationship model between Customer and Web Application
		IC4modelRelationship relCustomerWebApp = IModelElementFactory.instance().createC4modelRelationship();
		relCustomerWebApp.setName("Uses");
		relCustomerWebApp.setFrom(customer);
		relCustomerWebApp.setTo(webApp);
		// Create connector shape for the relationship between Customer and Web Application, and specify it's turning points. 
		IC4modelRelationshipUIModel relCustomerWebAppShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relCustomerWebApp, customerShape, webAppshape, new Point[] {new Point(250, 151), new Point(360, 151)});
		relCustomerWebAppShape.resetCaption();

		IC4modelRelationship relWebAppAPIGateway = IModelElementFactory.instance().createC4modelRelationship();
		relWebAppAPIGateway.setName("Calls");
		relWebAppAPIGateway.setFrom(webApp);
		relWebAppAPIGateway.setTo(apiGateway);
		IC4modelRelationshipUIModel relWebAppAPIGatewayShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relWebAppAPIGateway, webAppshape, apiGatewayShape, new Point[] {new Point(526, 151), new Point(630, 151)});
		relWebAppAPIGatewayShape.resetCaption();
		
		IC4modelRelationship relAPIGatewayBookService = IModelElementFactory.instance().createC4modelRelationship();
		relAPIGatewayBookService.setName("Calls");
		relAPIGatewayBookService.setFrom(apiGateway);
		relAPIGatewayBookService.setTo(bookService);
		IC4modelRelationshipUIModel relAPIGatewayBookServiceShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relAPIGatewayBookService, apiGatewayShape, bookServiceShape, new Point[] {new Point(796, 119), new Point(890, 119)});
		relAPIGatewayBookServiceShape.resetCaption();

		IC4modelRelationship relAPIGatewayUserService = IModelElementFactory.instance().createC4modelRelationship();
		relAPIGatewayUserService.setName("Calls");
		relAPIGatewayUserService.setFrom(apiGateway);
		relAPIGatewayUserService.setTo(userService);
		IC4modelRelationshipUIModel relAPIGatewayUserServiceShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relAPIGatewayUserService, apiGatewayShape, userServiceShape, new Point[] {new Point(796, 139), new Point(845, 139), new Point(845, 267), new Point(890, 267)});
		relAPIGatewayUserServiceShape.resetCaption();

		IC4modelRelationship relAPIGatewayOrderService = IModelElementFactory.instance().createC4modelRelationship();
		relAPIGatewayOrderService.setName("Calls");
		relAPIGatewayOrderService.setFrom(apiGateway);
		relAPIGatewayOrderService.setTo(orderService);
		IC4modelRelationshipUIModel relAPIGatewayOrderServiceShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relAPIGatewayOrderService, apiGatewayShape, orderServiceShape, new Point[] {new Point(796, 159), new Point(825, 159), new Point(825, 419), new Point(890, 419)});
		relAPIGatewayOrderServiceShape.resetCaption();

		IC4modelRelationship relBookServiceDatabase = IModelElementFactory.instance().createC4modelRelationship();
		relBookServiceDatabase.setName("Reads/Writes");
		relBookServiceDatabase.setFrom(bookService);
		relBookServiceDatabase.setTo(database);
		IC4modelRelationshipUIModel relBookServiceDatabaseShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relBookServiceDatabase, bookServiceShape, databaseShape, new Point[] {new Point(1058, 119), new Point(1180, 119)});
		relBookServiceDatabaseShape.resetCaption();

		IC4modelRelationship relUserServiceDatabase = IModelElementFactory.instance().createC4modelRelationship();
		relUserServiceDatabase.setName("Reads/Writes");
		relUserServiceDatabase.setFrom(userService);
		relUserServiceDatabase.setTo(database);
		IC4modelRelationshipUIModel relUserServiceDatabaseShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relUserServiceDatabase, userServiceShape, databaseShape, new Point[] {new Point(1050, 247), new Point(1090, 247), new Point(1090, 159), new Point(1180, 159)});
		relUserServiceDatabaseShape.resetCaption();

		IC4modelRelationship relUserServiceMessageBroker = IModelElementFactory.instance().createC4modelRelationship();
		relUserServiceMessageBroker.setName("Reads/Writes");
		relUserServiceMessageBroker.setFrom(userService);
		relUserServiceMessageBroker.setTo(messageBroker);
		IC4modelRelationshipUIModel relUserServiceMessageBrokerShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relUserServiceMessageBroker, userServiceShape, messageBrokerShape, new Point[] {new Point(1055, 277), new Point(1130, 277), new Point(1130, 410), new Point(1180, 410)});
		relUserServiceMessageBrokerShape.resetCaption();
		
		IC4modelRelationship relOrderServiceDatabase = IModelElementFactory.instance().createC4modelRelationship();
		relOrderServiceDatabase.setName("Reads/Writes");
		relOrderServiceDatabase.setFrom(orderService);
		relOrderServiceDatabase.setTo(database);
		IC4modelRelationshipUIModel relOrderServiceMessageDatabaseShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relOrderServiceDatabase, orderServiceShape, databaseShape, new Point[] {new Point(1055, 400), new Point(1110, 400), new Point(1110, 179), new Point(1180, 179)});
		relOrderServiceMessageDatabaseShape.resetCaption();

		IC4modelRelationship relOrderServiceMessageBroker = IModelElementFactory.instance().createC4modelRelationship();
		relOrderServiceMessageBroker.setName("Reads/Writes");
		relOrderServiceMessageBroker.setFrom(orderService);
		relOrderServiceMessageBroker.setTo(messageBroker);
		IC4modelRelationshipUIModel relOrderServiceMessageBrokerShape = (IC4modelRelationshipUIModel) diagramManager.createConnector(diagram, relOrderServiceMessageBroker, orderServiceShape, messageBrokerShape, new Point[] {new Point(1055, 440), new Point(1180, 440)});
		relOrderServiceMessageBrokerShape.resetCaption();
		
		// Show up the diagram
		diagramManager.openDiagram(diagram);

	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
