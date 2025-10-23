## Design a Document Editor Tool like Google Docs

### Basic Design

Start with some simple features:
- Elements: Document stores some elements like text and images
- Render: Document can render its element in formated structure
- Print Document: Print rendered doc in a file

```
Classes
|-----------------------------------------
|   Document
|-----------------------------------------
|   elements: String[]
|   renderedDocument: String
|-----------------------------------------
|   addText(text: string): void
|   addImage(imagePath: String): void
|   renderDocument(): String
|   printDocument(): void
|-----------------------------------------
```

This above design has many problems:
1. SRP: Single class responsible for many things like addText, addImage, renderDocument, printDocument.
2. OCP: To add new element we need to make changes in DocumentEditor class.
3. Don't have LSP, ISP, DIP principles.